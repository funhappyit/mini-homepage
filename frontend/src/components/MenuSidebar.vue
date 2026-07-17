<script setup lang="ts">
import { RouterLink } from 'vue-router'

const navLinks = [
  { to: '/', label: '홈' },
  { to: '/profile', label: '프로필' },
  { to: '/diary', label: '다이어리' },
  { to: '/favorites', label: '즐겨찾기' },
  { to: '/photo', label: '사진첩' },
  { to: '/board', label: '게시판' },
  { to: '/video', label: '동영상' },
  { to: '/guestbook', label: '방명록' },
]
</script>

<template>
  <nav class="nav-tabs">
    <RouterLink v-for="link in navLinks" :key="link.to" :to="link.to">
      {{ link.label }}
    </RouterLink>
  </nav>
</template>

<style scoped>
.nav-tabs {
  display: flex;
  flex-direction: column;
  border-radius: 8px;
  overflow: hidden;
}

.nav-tabs a {
  display: block;
  text-align: center;
  background: var(--tab-bg);
  color: #fff;
  font-weight: 700;
  font-size: 13px;
  text-decoration: none;
  padding: 9px 4px;
  border-top: 1px solid rgba(255, 255, 255, 0.25);
}

.nav-tabs a:first-child {
  border-top: none;
}

.nav-tabs a:hover {
  opacity: 0.9;
}

.nav-tabs a.router-link-exact-active {
  background: var(--tab-active);
  color: #fff;
}
</style>
