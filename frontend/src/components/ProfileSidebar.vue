<script setup lang="ts">
import { ref } from 'vue'
import { profile } from '../data/profile'

const historyOpen = ref(false)
</script>

<template>
  <aside class="profile-sidebar cy-panel">
    <div class="avatar">🧑‍💻</div>

    <button type="button" class="today-pill">TODAY IS... 😊</button>

    <div class="mood-quote">
      <p v-for="(line, idx) in profile.moodLines" :key="idx">{{ line }}</p>
    </div>

    <button type="button" class="history-toggle" @click="historyOpen = !historyOpen">
      <span>HISTORY</span>
      <span>{{ historyOpen ? '▲' : '▼' }}</span>
    </button>
    <ul v-if="historyOpen" class="history-list">
      <li v-for="skill in profile.skills" :key="skill">{{ skill }}</li>
    </ul>

    <p class="nickname">{{ profile.nickname }}</p>

    <div class="ilchon">
      <select class="ilchon-select" disabled>
        <option>일촌 목록</option>
      </select>
      <button type="button" class="ilchon-button">★ 일촌 파도타기</button>
    </div>
  </aside>
</template>

<style scoped>
.profile-sidebar {
  display: flex;
  flex-direction: column;
  gap: 9px;
  min-width: 0;
}

.today-pill {
  align-self: center;
  font-family: var(--font-cute);
  font-size: 12px;
  font-weight: 700;
  color: var(--text-h);
  background: var(--mint);
  border: 1px solid var(--mint-deep);
  border-radius: 3px;
  padding: 4px 12px;
  cursor: default;
}

.mood-quote {
  text-align: center;
  font-size: 13px;
  line-height: 1.5;
  color: var(--text);
}

.mood-quote p {
  margin: 0;
}

.history-toggle {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  border: none;
  background: none;
  font-weight: 700;
  font-size: 12px;
  color: var(--text-h);
  padding: 8px 0 0;
  border-top: 1px dashed var(--dashed-border);
  cursor: pointer;
}

.history-list {
  list-style: none;
  margin: 0;
  padding: 0;
  display: flex;
  flex-direction: column;
  gap: 4px;
  font-size: 12px;
  color: var(--text-muted);
}

.ilchon {
  display: flex;
  flex-direction: column;
  gap: 6px;
  border-top: 1px dashed var(--dashed-border);
  padding-top: 8px;
}

.ilchon-select {
  width: 100%;
}

.ilchon-button {
  font-family: var(--font-cute);
  font-size: 12px;
  font-weight: 700;
  color: #fff;
  background: var(--tab-bg);
  border: none;
  border-radius: 4px;
  padding: 8px;
  cursor: default;
}

.avatar {
  width: 100%;
  aspect-ratio: 1 / 1;
  border-radius: 5px;
  background:
    linear-gradient(135deg, rgba(255,255,255,.36), transparent),
    #cad9dc;
  border: 1px solid #777;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 56px;
}

.nickname {
  font-weight: 700;
  color: var(--text);
  font-size: 17px;
  margin: 0;
}
</style>
