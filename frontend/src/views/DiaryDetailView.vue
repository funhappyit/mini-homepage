<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { useRoute, RouterLink } from 'vue-router'
import { fetchDiaryDetail, type DiaryEntry } from '../api/diary'

const route = useRoute()
const entry = ref<DiaryEntry | null>(null)
const notFound = ref(false)

onMounted(async () => {
  try {
    entry.value = await fetchDiaryDetail(route.params.id as string)
  } catch {
    notFound.value = true
  }
})
</script>

<template>
  <section v-if="entry" class="detail retro-frame">
    <RouterLink to="/diary" class="back">← 목록으로</RouterLink>
    <h2>{{ entry.title }}</h2>
    <p class="date">{{ new Date(entry.createdAt).toLocaleString() }}</p>
    <p class="content">{{ entry.content }}</p>
  </section>
  <section v-else-if="notFound" class="detail retro-frame">
    <p>존재하지 않는 글입니다.</p>
    <RouterLink to="/diary" class="back">← 목록으로</RouterLink>
  </section>
</template>

<style scoped>
.detail {
  padding: 24px;
}

.back {
  display: inline-block;
  margin-bottom: 12px;
  font-size: 14px;
  text-decoration: none;
}

.date {
  font-size: 13px;
  color: var(--text-h);
  margin-bottom: 16px;
}

.content {
  white-space: pre-line;
}
</style>
