<script setup lang="ts">
import { useAuthStore } from '../stores/auth'
import { useRouter } from 'vue-router'

const authStore = useAuthStore()
const router = useRouter()

function handleLogout() {
  authStore.logout()
  router.push('/login')
}
</script>

<template>
  <section class="dashboard">
    <h1>관리자 대시보드</h1>
    <p>프로필/다이어리/방명록/미니룸 관리 기능은 각 단계에서 채워질 예정입니다.</p>
    <button type="button" @click="handleLogout">로그아웃</button>
  </section>
</template>

<style scoped>
.dashboard {
  padding: 2rem;
}
</style>
