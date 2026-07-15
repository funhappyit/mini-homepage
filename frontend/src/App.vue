<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <nav class="nav">
    <RouterLink to="/">홈</RouterLink>
    <RouterLink to="/admin">관리자</RouterLink>
  </nav>
  <RouterView />
</template>

<style scoped>
.nav {
  display: flex;
  gap: 1rem;
  padding: 1rem;
  border-bottom: 1px solid #eee;
}
</style>
