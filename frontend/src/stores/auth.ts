import { defineStore } from 'pinia'
import apiClient from '../api/client'

const ACCESS_TOKEN_KEY = 'mini-homepage.accessToken'
const REFRESH_TOKEN_KEY = 'mini-homepage.refreshToken'

interface TokenResponse {
  accessToken: string
  refreshToken: string
}

export const useAuthStore = defineStore('auth', {
  state: () => ({
    accessToken: localStorage.getItem(ACCESS_TOKEN_KEY),
    refreshToken: localStorage.getItem(REFRESH_TOKEN_KEY),
  }),

  getters: {
    isAuthenticated: (state) => !!state.accessToken,
  },

  actions: {
    async login(username: string, password: string) {
      const { data } = await apiClient.post<TokenResponse>('/api/v1/auth/login', {
        username,
        password,
      })
      this.setTokens(data)
    },

    async refresh() {
      if (!this.refreshToken) {
        throw new Error('Refresh token is missing')
      }

      const { data } = await apiClient.post<TokenResponse>('/api/v1/auth/refresh', {
        refreshToken: this.refreshToken,
      })
      this.setTokens(data)
    },

    setTokens(tokens: TokenResponse) {
      this.accessToken = tokens.accessToken
      this.refreshToken = tokens.refreshToken
      localStorage.setItem(ACCESS_TOKEN_KEY, tokens.accessToken)
      localStorage.setItem(REFRESH_TOKEN_KEY, tokens.refreshToken)
    },

    logout() {
      this.accessToken = null
      this.refreshToken = null
      localStorage.removeItem(ACCESS_TOKEN_KEY)
      localStorage.removeItem(REFRESH_TOKEN_KEY)
    },
  },
})
