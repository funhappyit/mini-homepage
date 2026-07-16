<script setup lang="ts">
import { RouterView } from 'vue-router'
import ProfileSidebar from './components/ProfileSidebar.vue'
import MenuSidebar from './components/MenuSidebar.vue'
import BgmPlayer from './components/BgmPlayer.vue'
import VisitCounter from './components/VisitCounter.vue'
import { profile } from './data/profile'
</script>

<template>
  <div class="cy-topbar">
    <VisitCounter />
    <a href="/" class="home-link">🏠 {{ profile.nickname }}의 미니홈피</a>
  </div>

  <div class="cy-layout">
    <ProfileSidebar />

    <section class="cy-main">
      <RouterView />
    </section>

    <MenuSidebar />
  </div>

  <span class="deco-sticker">🐑</span>

  <BgmPlayer />
</template>

<style scoped>
.deco-sticker {
  position: absolute;
  right: 8px;
  bottom: -10px;
  font-size: 40px;
}
</style>
