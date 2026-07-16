import { createRouter, createWebHistory } from 'vue-router'
import { useAuthStore } from '../stores/auth'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import AdminDashboardView from '../views/AdminDashboardView.vue'
import ProfileView from '../views/ProfileView.vue'
import DiaryView from '../views/DiaryView.vue'
import DiaryDetailView from '../views/DiaryDetailView.vue'
import GuestbookView from '../views/GuestbookView.vue'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'home', component: HomeView },
    { path: '/profile', name: 'profile', component: ProfileView },
    { path: '/diary', name: 'diary', component: DiaryView },
    { path: '/diary/:id', name: 'diary-detail', component: DiaryDetailView },
    { path: '/guestbook', name: 'guestbook', component: GuestbookView },
    { path: '/login', name: 'login', component: LoginView },
    {
      path: '/admin',
      name: 'admin',
      component: AdminDashboardView,
      meta: { requiresAuth: true },
    },
  ],
})

router.beforeEach((to) => {
  const authStore = useAuthStore()
  if (to.meta.requiresAuth && !authStore.isAuthenticated) {
    return { name: 'login' }
  }
  return true
})

export default router
