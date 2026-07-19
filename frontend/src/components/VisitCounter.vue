<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { fetchVisitStats, incrementVisit, type VisitStats } from '../api/visits'

const LAST_VISIT_KEY = 'mini-homepage.lastVisitDate'

const stats = ref<VisitStats>({ today: 0, total: 0 })

onMounted(async () => {
  const todayStr = new Date().toDateString()
  const lastVisit = localStorage.getItem(LAST_VISIT_KEY)

  try {
    if (lastVisit === todayStr) {
      stats.value = await fetchVisitStats()
    } else {
      stats.value = await incrementVisit()
      localStorage.setItem(LAST_VISIT_KEY, todayStr)
    }
  } catch {
    // 방문자수 조회 실패는 화면에 영향 주지 않고 조용히 무시
  }
})
</script>

<template>
  <div class="visit-counter">
    <span>Today <strong>{{ stats.today }}</strong></span>
    <span class="divider">|</span>
    <span>Total <strong>{{ stats.total }}</strong></span>
  </div>
</template>

<style scoped>
.visit-counter {
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 13px;
  color: var(--text-h);
}

.visit-counter strong {
  color: #d9435e;
}

.divider {
  color: var(--border);
}
</style>
