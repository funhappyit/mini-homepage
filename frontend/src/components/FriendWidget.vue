<script setup lang="ts">
import { profile } from '../data/profile'

// [장식용] 실데이터 연동 없는 정적 위젯 - 무드 게이지/마이심볼/추천 BGM을 흉내만 냄
const moods = [
  { label: '고독', percent: 60, color: '#e57373' },
  { label: '슬픔', percent: 35, color: '#81c784' },
  { label: '설렘', percent: 80, color: '#64b5f6' },
]
const symbols = [
  { color: '#e57373', icon: '🌱' },
  { color: '#64b5f6', icon: '💧' },
  { color: '#81c784', icon: '🐾' },
  { color: '#ba68c8', icon: '🔥' },
]
const recommendedBgm = [
  { color: '#cfd8dc', label: '[임시] 아티스트 A', tag: '#f2d675' },
  { color: '#d7ccc8', label: '[임시] 아티스트 B', tag: '#f2d675' },
]
</script>

<template>
  <aside class="friend-widget">
    <div class="fw-header">마이홈</div>

    <div class="fw-body">
      <div class="fw-block">
        <div v-for="mood in moods" :key="mood.label" class="mood-row">
          <span class="mood-label">{{ mood.label }}</span>
          <span class="mood-bar">
            <span class="mood-fill" :style="{ width: mood.percent + '%', background: mood.color }" />
          </span>
          <span class="mood-arrows">
            <button type="button" disabled>▲</button>
            <button type="button" disabled>▼</button>
          </span>
        </div>
      </div>

      <div class="fw-block">
        <p class="fw-title">마이심볼</p>
        <div class="fw-items">
          <span
            v-for="symbol in symbols"
            :key="symbol.color"
            class="item-swatch"
            :style="{ background: symbol.color }"
            >{{ symbol.icon }}</span
          >
        </div>
      </div>

      <div class="fw-block fw-links">
        <a href="#" @click.prevent>스크랩</a>
        <span class="divider">|</span>
        <a href="#" @click.prevent>즐겨찾기</a>
      </div>

      <div class="fw-block fw-photo">
        <span class="photo-thumb">📷</span>
        <div class="photo-info">
          <p class="photo-title">사진 · {{ profile.nickname }}</p>
          <div class="photo-controls">
            <button type="button" disabled>❚❚</button>
            <button type="button" disabled>◀◀</button>
            <button type="button" disabled>▶▶</button>
            <span class="photo-progress"><span class="photo-progress-fill" /></span>
            <button type="button" class="photo-list-btn" disabled>LIST</button>
          </div>
        </div>
      </div>

      <div class="fw-block">
        <div class="fw-title-row">
          <p class="fw-title">선물가게 · 추천 BGM</p>
          <span class="fw-toggle">▲</span>
        </div>
        <div class="fw-bgm">
          <div v-for="bgm in recommendedBgm" :key="bgm.label" class="bgm-item">
            <span class="bgm-swatch" :style="{ background: bgm.color }" />
            <span class="bgm-label" :style="{ background: bgm.tag }">{{ bgm.label }}</span>
          </div>
        </div>
      </div>
    </div>
  </aside>
</template>

<style scoped>
.friend-widget {
  display: flex;
  flex-direction: column;
  font-size: 12px;
  border-radius: 3px;
  overflow: hidden;
  border: 1px solid #5e5e5e;
}

.fw-header {
  background: #555;
  color: #fff;
  font-family: var(--font-cute);
  font-weight: 700;
  font-size: 12px;
  text-align: center;
  padding: 4px;
}

.fw-body {
  display: flex;
  flex-direction: column;
  gap: 3px;
  background: var(--card-bg);
  padding: 5px 7px;
}

.fw-block {
  border-top: 1px dashed var(--dashed-border);
  padding-top: 4px;
}

.fw-block:first-child {
  border-top: none;
  padding-top: 0;
}

.fw-title {
  margin: 0 0 4px;
  font-weight: 700;
  color: var(--text-h);
  font-size: 12px;
}

.mood-row {
  display: flex;
  align-items: center;
  gap: 6px;
  margin-bottom: 2px;
}

.mood-label {
  width: 28px;
  flex-shrink: 0;
  color: var(--text-muted);
}

.mood-bar {
  flex: 1;
  height: 8px;
  background: var(--mint);
  border-radius: 999px;
  overflow: hidden;
}

.mood-fill {
  display: block;
  height: 100%;
}

.mood-arrows {
  display: flex;
  flex-direction: column;
  line-height: 1;
}

.mood-arrows button {
  border: none;
  background: none;
  color: var(--text-muted);
  font-size: 8px;
  padding: 0;
  cursor: default;
}

.fw-items {
  display: flex;
  gap: 6px;
}

.item-swatch {
  width: 22px;
  height: 22px;
  border-radius: 50%;
  border: 1px solid var(--card-border);
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 11px;
}

.fw-links {
  display: flex;
  gap: 6px;
  color: var(--tab-bg);
}

.fw-links a {
  text-decoration: none;
}

.fw-links .divider {
  color: var(--border);
}

.fw-photo {
  display: flex;
  align-items: center;
  gap: 6px;
}

.photo-thumb {
  flex-shrink: 0;
  width: 22px;
  height: 22px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: var(--mint);
  border: 1px solid var(--card-border);
  border-radius: 4px;
  font-size: 14px;
}

.photo-info {
  flex: 1;
  min-width: 0;
}

.photo-title {
  margin: 0 0 3px;
  font-size: 11px;
  color: var(--text);
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.photo-controls {
  display: flex;
  align-items: center;
  gap: 4px;
}

.photo-controls button {
  border: none;
  background: none;
  color: var(--text-muted);
  font-size: 9px;
  padding: 0;
  cursor: default;
}

.photo-progress {
  flex: 1;
  display: block;
  height: 4px;
  border-radius: 999px;
  background: var(--mint);
  overflow: hidden;
}

.photo-progress-fill {
  display: block;
  width: 40%;
  height: 100%;
  background: var(--tab-bg);
}

.photo-controls .photo-list-btn {
  font-size: 9px;
  font-weight: 700;
  color: var(--text-muted);
  border: 1px solid var(--dashed-border);
  border-radius: 3px;
  padding: 1px 4px;
}

.fw-title-row {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.fw-title-row .fw-title {
  margin: 0;
}

.fw-toggle {
  font-size: 9px;
  color: var(--text-muted);
}

.fw-bgm {
  display: flex;
  gap: 8px;
  margin-top: 6px;
}

.bgm-item {
  flex: 1;
  min-width: 0;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 4px;
}

.bgm-swatch {
  width: 100%;
  aspect-ratio: 2.6 / 1;
  border-radius: 6px;
  border: 1px solid var(--card-border);
}

.bgm-label {
  max-width: 100%;
  overflow: hidden;
  font-size: 10px;
  font-weight: 700;
  color: var(--text);
  text-align: center;
  text-overflow: ellipsis;
  border-radius: 999px;
  padding: 2px 8px;
  white-space: nowrap;
}
</style>
