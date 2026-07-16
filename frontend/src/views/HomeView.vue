<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { RouterLink } from 'vue-router'
import { profile } from '../data/profile'
import MiniRoomIllustration from '../components/MiniRoomIllustration.vue'
import { fetchDiaryList, type DiaryEntry } from '../api/diary'
import { fetchGuestbook, type GuestbookEntry } from '../api/guestbook'

const latestDiary = ref<DiaryEntry[]>([])
const latestGuestbook = ref<GuestbookEntry[]>([])

onMounted(async () => {
  try {
    latestDiary.value = (await fetchDiaryList()).slice(0, 2)
  } catch {
    latestDiary.value = []
  }
  try {
    latestGuestbook.value = (await fetchGuestbook()).slice(0, 1)
  } catch {
    latestGuestbook.value = []
  }
})
</script>

<template>
  <section class="home">
    <div class="news retro-frame">
      <h2>📰 Updated news</h2>
      <ul class="news-list">
        <li v-for="entry in latestDiary" :key="`d-${entry.id}`">
          <RouterLink :to="`/diary/${entry.id}`">📔 {{ entry.title }}</RouterLink>
        </li>
        <li v-for="entry in latestGuestbook" :key="`g-${entry.id}`">
          <RouterLink to="/guestbook">📮 {{ entry.nickname }}님이 방명록을 남겼어요</RouterLink>
        </li>
        <li v-if="latestDiary.length === 0 && latestGuestbook.length === 0" class="empty">
          아직 새 소식이 없어요.
        </li>
      </ul>
    </div>

    <div class="room retro-frame">
      <h2>🏠 {{ profile.nickname }}의 미니룸</h2>
      <MiniRoomIllustration />
      <div class="room-links">
        <span>[ 미니룸수 0 ]</span>
        <span>[ 일촌맺기 ]</span>
        <span>[ 미니룸 달성기록 ]</span>
      </div>
    </div>

    <div class="profile-card retro-frame">
      <p class="status">💬 {{ profile.statusMessage }}</p>
      <p class="bio">{{ profile.bio }}</p>
      <RouterLink to="/profile" class="retro-button">프로필 더보기</RouterLink>
    </div>
  </section>
</template>

<style scoped>
.home {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.news-list {
  list-style: none;
  padding: 0;
  margin: 8px 0 0;
  display: flex;
  flex-direction: column;
  gap: 6px;
  font-size: 13px;
}

.news-list a {
  text-decoration: none;
}

.empty {
  color: var(--text);
  opacity: 0.7;
}

.room-links {
  display: flex;
  justify-content: center;
  gap: 12px;
  margin-top: 10px;
  font-size: 11px;
  color: var(--text-h);
  opacity: 0.8;
}

.profile-card {
  text-align: center;
}

.status {
  font-family: var(--font-cute);
  font-size: 16px;
  color: var(--text-h);
}

.bio {
  margin: 8px 0 16px;
  white-space: pre-line;
}
</style>
