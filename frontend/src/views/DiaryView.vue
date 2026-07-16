<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { RouterLink } from 'vue-router'
import { fetchDiaryList, type DiaryEntry } from '../api/diary'

const entries = ref<DiaryEntry[]>([])
const loading = ref(false)
const errorMessage = ref('')

async function loadEntries() {
  loading.value = true
  errorMessage.value = ''
  try {
    entries.value = await fetchDiaryList()
  } catch {
    errorMessage.value = '다이어리를 불러오지 못했습니다.'
  } finally {
    loading.value = false
  }
}

function excerpt(content: string) {
  return content.length > 80 ? `${content.slice(0, 80)}...` : content
}

onMounted(loadEntries)
</script>

<template>
  <section class="diary">
    <h2>📔 다이어리</h2>

    <p v-if="loading">불러오는 중...</p>
    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>

    <div class="grid">
      <RouterLink
        v-for="entry in entries"
        :key="entry.id"
        :to="`/diary/${entry.id}`"
        class="card retro-frame"
      >
        <h3>{{ entry.title }}</h3>
        <p class="date">{{ new Date(entry.createdAt).toLocaleDateString() }}</p>
        <p class="excerpt">{{ excerpt(entry.content) }}</p>
      </RouterLink>
    </div>

    <p v-if="!loading && entries.length === 0">아직 작성된 다이어리 글이 없어요.</p>
  </section>
</template>

<style scoped>
.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
  gap: 16px;
  margin-top: 16px;
}

.card {
  text-decoration: none;
  color: var(--text);
  display: block;
  transition: transform 0.15s;
}

.card:hover {
  transform: translateY(-4px);
}

.date {
  font-size: 12px;
  color: var(--text-h);
  margin-bottom: 8px;
}

.error {
  color: #d9435e;
}
</style>
