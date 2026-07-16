<script setup lang="ts">
import { profile } from '../data/profile'
</script>

<template>
  <aside class="profile-sidebar cy-panel">
    <div class="mood-box">TODAY is ... {{ profile.mood }}</div>

    <div class="avatar">🧑‍💻</div>
    <p class="nickname">{{ profile.nickname }}</p>
    <p class="status">{{ profile.statusMessage }}</p>

    <ul class="history">
      <li>· 미니홈피 개설 [임시]</li>
      <li>· 일촌 [임시] 0명</li>
      <li>· 방명록 남기고 가기 →</li>
    </ul>
  </aside>
</template>

<style scoped>
.profile-sidebar {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  text-align: center;
}

.mood-box {
  width: 100%;
  font-family: var(--font-cute);
  font-size: 12px;
  color: var(--text-h);
  background: #fff0f5;
  border: 1px dashed var(--pink);
  border-radius: 999px;
  padding: 6px 4px;
}

.avatar {
  width: 140px;
  height: 140px;
  border-radius: 12px;
  background: linear-gradient(160deg, #ffeef4, #ffd9e5);
  border: 2px solid var(--pink);
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 64px;
}

.nickname {
  font-family: var(--font-cute);
  font-size: 16px;
  color: var(--text-h);
  margin: 0;
}

.status {
  font-size: 13px;
  margin: 0 0 4px;
}

.history {
  width: 100%;
  list-style: none;
  padding: 12px 0 0;
  margin: 4px 0 0;
  border-top: 1px dashed var(--border);
  font-size: 12px;
  text-align: left;
  display: flex;
  flex-direction: column;
  gap: 6px;
}
</style>
