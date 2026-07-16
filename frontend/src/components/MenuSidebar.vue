<script setup lang="ts">
import { RouterLink } from 'vue-router'

const menuItems = [
  { to: '/', label: '홈', icon: '🏠' },
  { to: '/profile', label: '프로필', icon: '👤' },
  { to: '/diary', label: '다이어리', icon: '📔' },
  { to: '/guestbook', label: '방명록', icon: '📮' },
]
</script>

<template>
  <nav class="menu-sidebar">
    <RouterLink v-for="item in menuItems" :key="item.to" :to="item.to" class="menu-link">
      <span class="icon">{{ item.icon }}</span>
      <span class="label">{{ item.label }}</span>
    </RouterLink>
  </nav>
</template>

<style scoped>
.menu-sidebar {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 8px;
  align-self: center;
  width: 100%;
}

.menu-link {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 4px;
  font-family: var(--font-cute);
  font-size: 12px;
  color: #2d6e56;
  text-decoration: none;
  padding: 12px 4px;
  border-radius: 10px;
  background: var(--mint);
  border: 1px solid var(--mint-deep);
}

.icon {
  font-size: 20px;
}

.menu-link.router-link-exact-active {
  background: var(--mint-deep);
  color: #fff;
}
</style>
