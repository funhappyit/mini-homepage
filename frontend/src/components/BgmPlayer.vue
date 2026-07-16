<script setup lang="ts">
import { ref } from 'vue'

// [임시] public/audio/bgm.mp3 자리에 실제 음원 파일을 넣어주세요.
const BGM_SRC = '/audio/bgm.mp3'

const audio = ref<HTMLAudioElement>()
const isPlaying = ref(false)
const hasError = ref(false)

function toggle() {
  const el = audio.value
  if (!el) return

  if (isPlaying.value) {
    el.pause()
    isPlaying.value = false
    return
  }

  el.play()
    .then(() => {
      isPlaying.value = true
    })
    .catch(() => {
      hasError.value = true
    })
}

function onError() {
  hasError.value = true
}
</script>

<template>
  <div class="bgm-player">
    <audio ref="audio" :src="BGM_SRC" loop @error="onError" />
    <button
      type="button"
      class="bgm-widget"
      :disabled="hasError"
      :title="hasError ? '음원 파일이 없어요 (public/audio/bgm.mp3)' : isPlaying ? '음악 끄기' : '음악 켜기'"
      @click="toggle"
    >
      <span class="icon">{{ hasError ? '🔇' : '🎵' }}</span>
      <span class="label">{{ isPlaying ? 'Now Playing' : 'BGM' }}</span>
    </button>
  </div>
</template>

<style scoped>
.bgm-player {
  position: absolute;
  top: -34px;
  right: -100px;
}

@media (max-width: 1200px) {
  .bgm-player {
    position: fixed;
    top: auto;
    bottom: 20px;
    right: 20px;
  }
}

.bgm-widget {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 4px;
  width: 92px;
  padding: 14px 8px;
  border-radius: 12px;
  border: 3px dashed #fff;
  background: #ffeaf1;
  box-shadow: 0 6px 0 rgba(255, 111, 145, 0.2);
  cursor: pointer;
}

.icon {
  font-size: 26px;
}

.label {
  font-family: var(--font-cute);
  font-size: 11px;
  color: var(--text-h);
}

.bgm-widget:disabled {
  cursor: not-allowed;
  opacity: 0.6;
}
</style>
