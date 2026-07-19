<script setup lang="ts">
import { RouterLink } from 'vue-router'

const navLinks = [
  { to: '/', label: '홈' },
  { to: '/profile', label: '프로필' },
  { to: '/diary', label: '다이어리' },
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
  gap: 4px;
  padding-top: 7px;
  position: absolute;
  z-index: 2;
  top: 0;
  right: -52px;
  width: 54px;
}

.nav-tabs a {
  display: block;
  text-align: center;
  background: var(--tab-bg);
  color: #fff;
  font-weight: 700;
  font-size: 12px;
  text-decoration: none;
  padding: 7px 2px;
  border: 1px solid #18516f;
  border-radius: 4px 0 0 4px;
}

.nav-tabs a:hover {
  opacity: 0.9;
}

.nav-tabs a.router-link-exact-active {
  position: relative;
  z-index: 1;
  margin-left: -9px;
  padding-left: 11px;
  background: var(--card-bg);
  color: var(--tab-active);
  border: 2px solid var(--card-border);
  border-left: none;
  border-radius: 8px;
}
</style>
