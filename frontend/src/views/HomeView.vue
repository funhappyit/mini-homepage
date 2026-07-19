<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { RouterLink } from 'vue-router'
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
    latestGuestbook.value = (await fetchGuestbook()).slice(0, 3)
  } catch {
    latestGuestbook.value = []
  }
})
</script>

<template>
  <section class="home">
    <div class="news">
      <h2 class="section-title">Updated news</h2>
      <ul class="news-list">
        <li v-for="entry in latestDiary" :key="`d-${entry.id}`">
          <RouterLink :to="`/diary/${entry.id}`">·[다이어리] {{ entry.title }}</RouterLink>
        </li>
        <li v-for="entry in latestGuestbook" :key="`g-${entry.id}`">
          <RouterLink to="/guestbook">·[방명록] {{ entry.nickname }}님이 글을 남겼어요</RouterLink>
        </li>
        <li v-if="latestDiary.length === 0 && latestGuestbook.length === 0" class="empty">
          아직 새 소식이 없어요.
        </li>
      </ul>
    </div>

    <div class="room">
      <div class="section-header">
        <h2 class="section-title">Miniroom</h2>
        <span class="section-caption">그저 멍하니 하늘만 바라봐</span>
      </div>
      <MiniRoomIllustration />
    </div>

    <div class="friends-say">
      <div class="section-header">
        <h2 class="section-title">What friends say</h2>
        <span class="section-caption">한마디씩 표현해보자~</span>
      </div>
      <ul class="friends-list">
        <li v-for="entry in latestGuestbook" :key="entry.id">
          {{ entry.content }} <span class="who">({{ entry.nickname }})</span>
        </li>
        <li v-if="latestGuestbook.length === 0" class="empty">아직 남겨진 말이 없어요.</li>
      </ul>
    </div>
  </section>
</template>

<style scoped>
.home {
  display: flex;
  flex-direction: column;
  height: 100%;
  gap: 7px;
}

.section-title {
  font-family: var(--font-cute);
  font-size: 13px;
  font-weight: 700;
  color: var(--text-h);
  margin: 0;
}

.section-header {
  display: flex;
  align-items: baseline;
  justify-content: space-between;
  gap: 8px;
  border-bottom: 2px solid #c4c4c4;
  padding: 0 0 3px;
}

.section-caption {
  font-size: 12px;
  color: var(--text-muted);
}

.news {
  flex: 0 0 103px;
  border-bottom: 1px solid #c4c4c4;
  padding-bottom: 5px;
}

.news-list {
  list-style: none;
  padding: 0;
  margin: 5px 0 0;
  display: flex;
  flex-direction: column;
  gap: 3px;
  font-size: 12px;
}

.news-list a {
  text-decoration: none;
}

.empty {
  color: var(--text);
  opacity: 0.7;
}

.friends-list {
  list-style: none;
  margin: 5px 0 0;
  padding: 0;
  display: flex;
  flex-direction: column;
  gap: 2px;
  font-size: 12px;
}

.who {
  color: var(--text-muted);
  font-size: 12px;
}

.room {
  flex: 1 1 auto;
  min-height: 0;
  display: flex;
  flex-direction: column;
}

.room :deep(.room-scene) {
  flex: 1 1 auto;
  min-height: 0;
  max-width: none;
  width: 100%;
  margin-top: 5px;
}

.friends-say {
  flex: 0 0 67px;
}
</style>
