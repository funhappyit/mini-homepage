<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useAuthStore } from '../stores/auth'

const username = ref('')
const password = ref('')
const errorMessage = ref('')
const isSubmitting = ref(false)

const authStore = useAuthStore()
const router = useRouter()

async function handleSubmit() {
  errorMessage.value = ''
  isSubmitting.value = true
  try {
    await authStore.login(username.value, password.value)
    router.push('/admin')
  } catch {
    errorMessage.value = '아이디 또는 비밀번호가 올바르지 않습니다.'
  } finally {
    isSubmitting.value = false
  }
}
</script>

<template>
  <section class="login">
    <h1>관리자 로그인</h1>
    <form @submit.prevent="handleSubmit">
      <label>
        아이디
        <input v-model="username" type="text" autocomplete="username" required />
      </label>
      <label>
        비밀번호
        <input v-model="password" type="password" autocomplete="current-password" required />
      </label>
      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
      <button type="submit" :disabled="isSubmitting">로그인</button>
    </form>
  </section>
</template>

<style scoped>
.login {
  max-width: 320px;
  margin: 4rem auto;
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

form {
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.error {
  color: #d33;
  margin: 0;
}
</style>
