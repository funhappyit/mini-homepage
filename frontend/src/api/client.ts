import axios from 'axios'
import { useAuthStore } from '../stores/auth'

const apiClient = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL ?? 'http://localhost:8081',
})

let refreshPromise: Promise<void> | null = null

function isAuthRequest(url?: string) {
  return url?.includes('/api/v1/auth/') ?? false
}

apiClient.interceptors.request.use((config) => {
  const authStore = useAuthStore()
  if (authStore.accessToken) {
    config.headers.Authorization = `Bearer ${authStore.accessToken}`
  }
  return config
})

apiClient.interceptors.response.use(
  (response) => response,
  async (error) => {
    const originalRequest = error.config as { _retry?: boolean; url?: string } | undefined
    const status = error.response?.status

    if (status !== 401 || !originalRequest || originalRequest._retry || isAuthRequest(originalRequest.url)) {
      return Promise.reject(error)
    }

    const authStore = useAuthStore()
    if (!authStore.refreshToken) {
      authStore.logout()
      redirectToLogin()
      return Promise.reject(error)
    }

    originalRequest._retry = true

    try {
      if (!refreshPromise) {
        refreshPromise = authStore.refresh().finally(() => {
          refreshPromise = null
        })
      }
      await refreshPromise
      return apiClient(originalRequest)
    } catch {
      authStore.logout()
      redirectToLogin()
      return Promise.reject(error)
    }
  },
)

function redirectToLogin() {
  if (window.location.pathname !== '/login') {
    window.location.assign('/login')
  }
}

export default apiClient
