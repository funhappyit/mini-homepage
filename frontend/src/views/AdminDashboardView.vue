<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { useAuthStore } from '../stores/auth'
import { useRouter } from 'vue-router'
import {
  createDiaryEntry,
  deleteDiaryEntry,
  fetchDiaryList,
  updateDiaryEntry,
  type DiaryEntry,
} from '../api/diary'

const authStore = useAuthStore()
const router = useRouter()

const entries = ref<DiaryEntry[]>([])
const errorMessage = ref('')
const editingId = ref<number | null>(null)
const form = ref({ title: '', content: '' })

async function loadEntries() {
  try {
    entries.value = await fetchDiaryList()
  } catch {
    errorMessage.value = '다이어리 목록을 불러오지 못했습니다.'
  }
}

function startCreate() {
  editingId.value = null
  form.value = { title: '', content: '' }
}

function startEdit(entry: DiaryEntry) {
  editingId.value = entry.id
  form.value = { title: entry.title, content: entry.content }
}

async function submit() {
  if (!form.value.title || !form.value.content) {
    errorMessage.value = '제목과 내용을 입력해주세요.'
    return
  }
  errorMessage.value = ''
  try {
    if (editingId.value) {
      await updateDiaryEntry(editingId.value, { ...form.value })
    } else {
      await createDiaryEntry({ ...form.value })
    }
    startCreate()
    await loadEntries()
  } catch {
    errorMessage.value = '저장에 실패했습니다.'
  }
}

async function removeEntry(id: number) {
  if (!window.confirm('이 글을 삭제할까요?')) {
    return
  }
  try {
    await deleteDiaryEntry(id)
    if (editingId.value === id) {
      startCreate()
    }
    await loadEntries()
  } catch {
    errorMessage.value = '삭제에 실패했습니다.'
  }
}

function handleLogout() {
  authStore.logout()
  router.push('/login')
}

onMounted(loadEntries)
</script>

<template>
  <section class="dashboard">
    <div class="dashboard-header">
      <h1>관리자 대시보드</h1>
      <button type="button" class="retro-button secondary" @click="handleLogout">로그아웃</button>
    </div>

    <h2>다이어리 {{ editingId ? '수정' : '작성' }}</h2>
    <form class="write-form retro-frame" @submit.prevent="submit">
      <input v-model="form.title" type="text" placeholder="제목" maxlength="100" />
      <textarea v-model="form.content" rows="6" placeholder="내용을 입력해주세요" />
      <div class="form-actions">
        <button type="submit" class="retro-button">{{ editingId ? '수정 완료' : '작성하기' }}</button>
        <button v-if="editingId" type="button" class="retro-button secondary" @click="startCreate">
          취소
        </button>
      </div>
    </form>

    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>

    <h2>다이어리 목록</h2>
    <ul class="entries">
      <li v-for="entry in entries" :key="entry.id" class="entry retro-frame">
        <div class="entry-head">
          <strong>{{ entry.title }}</strong>
          <span class="date">{{ new Date(entry.createdAt).toLocaleDateString() }}</span>
        </div>
        <div class="entry-actions">
          <button type="button" class="retro-button secondary small" @click="startEdit(entry)">수정</button>
          <button type="button" class="retro-button secondary small" @click="removeEntry(entry.id)">삭제</button>
        </div>
      </li>
    </ul>
    <p v-if="entries.length === 0">아직 작성된 다이어리 글이 없어요.</p>
  </section>
</template>

<style scoped>
.dashboard {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.dashboard-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.write-form {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

textarea {
  resize: vertical;
  width: 100%;
}

.form-actions {
  display: flex;
  gap: 8px;
}

.error {
  color: #d9435e;
}

.entries {
  list-style: none;
  padding: 0;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.entry-head {
  display: flex;
  justify-content: space-between;
  align-items: baseline;
  margin-bottom: 8px;
}

.date {
  font-size: 12px;
  color: var(--text-h);
}

.entry-actions {
  display: flex;
  gap: 6px;
}

.small {
  font-size: 12px;
  padding: 4px 12px;
}
</style>
