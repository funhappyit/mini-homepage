<script setup lang="ts">
import { onMounted, ref } from 'vue'
import {
  createGuestbookEntry,
  deleteGuestbookEntry,
  fetchGuestbook,
  type GuestbookEntry,
} from '../api/guestbook'

const entries = ref<GuestbookEntry[]>([])
const loading = ref(false)
const errorMessage = ref('')

const form = ref({ nickname: '', password: '', content: '' })

async function loadEntries() {
  loading.value = true
  errorMessage.value = ''
  try {
    entries.value = await fetchGuestbook()
  } catch {
    errorMessage.value = '방명록을 불러오지 못했습니다.'
  } finally {
    loading.value = false
  }
}

async function submit() {
  if (!form.value.nickname || !form.value.password || !form.value.content) {
    errorMessage.value = '닉네임, 비밀번호, 내용을 모두 입력해주세요.'
    return
  }
  errorMessage.value = ''
  try {
    await createGuestbookEntry({ ...form.value })
    form.value.content = ''
    await loadEntries()
  } catch {
    errorMessage.value = '글 작성에 실패했습니다.'
  }
}

async function removeEntry(id: number) {
  const password = window.prompt('작성 시 입력한 비밀번호를 입력해주세요.')
  if (!password) {
    return
  }
  try {
    await deleteGuestbookEntry(id, password)
    await loadEntries()
  } catch {
    errorMessage.value = '삭제에 실패했습니다. 비밀번호를 확인해주세요.'
  }
}

onMounted(loadEntries)
</script>

<template>
  <section class="guestbook">
    <h2>📮 방명록</h2>

    <form class="write-form retro-frame" @submit.prevent="submit">
      <div class="row">
        <input v-model="form.nickname" type="text" placeholder="닉네임" maxlength="30" />
        <input v-model="form.password" type="password" placeholder="비밀번호" maxlength="100" />
      </div>
      <textarea v-model="form.content" rows="3" placeholder="방명록에 남길 말을 적어주세요 🥑" maxlength="500" />
      <button type="submit" class="retro-button">남기기</button>
    </form>

    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
    <p v-if="loading">불러오는 중...</p>

    <ul class="entries">
      <li v-for="entry in entries" :key="entry.id" class="entry retro-frame">
        <div class="entry-head">
          <strong>{{ entry.nickname }}</strong>
          <span class="date">{{ new Date(entry.createdAt).toLocaleString() }}</span>
        </div>
        <p class="content">{{ entry.content }}</p>
        <button type="button" class="retro-button secondary small" @click="removeEntry(entry.id)">
          삭제
        </button>
      </li>
    </ul>
    <p v-if="!loading && entries.length === 0">아직 남겨진 방명록이 없어요. 첫 글을 남겨보세요!</p>
  </section>
</template>

<style scoped>
.guestbook {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.write-form {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.row {
  display: flex;
  gap: 10px;
}

.row input {
  flex: 1;
  min-width: 0;
}

textarea {
  resize: vertical;
  width: 100%;
}

.error {
  color: #d9435e;
}

.entries {
  list-style: none;
  padding: 0;
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.entry-head {
  display: flex;
  justify-content: space-between;
  align-items: baseline;
  margin-bottom: 6px;
}

.date {
  font-size: 12px;
  color: var(--text-h);
}

.content {
  white-space: pre-line;
  margin-bottom: 8px;
}

.small {
  font-size: 12px;
  padding: 4px 12px;
}
</style>
