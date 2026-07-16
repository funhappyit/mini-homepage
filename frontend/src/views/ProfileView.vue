<script setup lang="ts">
import { profile } from '../data/profile'
</script>

<template>
  <section class="profile retro-frame">
    <h2>👩‍💻 {{ profile.nickname }}</h2>
    <p class="status">💬 {{ profile.statusMessage }}</p>
    <p class="bio">{{ profile.bio }}</p>

    <h3>기술 스택</h3>
    <ul class="skills">
      <li v-for="skill in profile.skills" :key="skill">{{ skill }}</li>
    </ul>

    <h3>연락처</h3>
    <ul class="contacts">
      <li v-for="contact in profile.contacts" :key="contact.label">
        <span class="label">{{ contact.label }}</span>
        <a v-if="contact.href" :href="contact.href" target="_blank" rel="noopener">{{ contact.value }}</a>
        <span v-else>{{ contact.value }}</span>
      </li>
    </ul>
  </section>
</template>

<style scoped>
.profile {
  padding: 24px;
}

.status {
  font-family: var(--font-cute);
  color: var(--text-h);
}

.bio {
  white-space: pre-line;
  margin-bottom: 16px;
}

.skills,
.contacts {
  list-style: none;
  padding: 0;
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
}

.skills li {
  background: var(--mint);
  border-radius: 999px;
  padding: 6px 14px;
  font-size: 14px;
}

.contacts {
  flex-direction: column;
}

.contacts li {
  display: flex;
  gap: 8px;
}

.contacts .label {
  font-weight: bold;
  color: var(--text-h);
  min-width: 70px;
}
</style>
