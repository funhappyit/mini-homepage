<script setup lang="ts">
import { RouterView } from 'vue-router'
import ProfileSidebar from './components/ProfileSidebar.vue'
import NavTabs from './components/MenuSidebar.vue'
import FriendWidget from './components/FriendWidget.vue'
import VisitCounter from './components/VisitCounter.vue'
import { profile } from './data/profile'

const siteUrl = typeof window !== 'undefined' ? window.location.origin : ''
</script>

<template>
  <div class="cy-box">
    <div class="book-header">
      <VisitCounter />
      <span class="book-title">📷 {{ profile.diaryTitle }}</span>
      <span class="book-url">{{ siteUrl }}</span>
    </div>

    <div class="cy-layout">
      <ProfileSidebar />
      <div class="book-spine" />

      <section class="cy-main">
        <RouterView />
      </section>

      <NavTabs />
      <FriendWidget />
    </div>
  </div>
</template>
