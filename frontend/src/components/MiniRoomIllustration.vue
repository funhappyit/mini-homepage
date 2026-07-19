<script setup lang="ts">
// CSS/SVG로 간이 표현한 아이소메트릭 미니룸 (실제 이미지 파일 미사용)
</script>

<template>
  <div class="room-scene">
    <div class="wall wall-left" />
    <div class="wall wall-right" />
    <div class="window">
      <span class="mullion-v" />
      <span class="mullion-h" />
    </div>
    <div class="floor" />

    <div class="bookshelf">
      <span /><span /><span />
    </div>

    <div class="bed">
      <div class="pillow" />
      <div class="blanket" />
    </div>

    <div class="rug" />
    <div class="plant">🪴</div>
  </div>
</template>

<style scoped>
.room-scene {
  position: relative;
  width: 100%;
  max-width: none;
  aspect-ratio: 16 / 9;
  margin: 0 auto;
  border: 1px solid #b7b7b7;
  border-radius: 0;
  overflow: hidden;
}

.wall {
  position: absolute;
  top: 0;
  width: 50%;
  height: 65%;
}

.wall-left {
  left: 0;
  background: #cfe6ee;
  clip-path: polygon(0 10%, 100% 0, 100% 100%, 0 90%);
}

.wall-right {
  right: 0;
  background: #bcdce8;
  clip-path: polygon(0 0, 100% 10%, 100% 90%, 0 100%);
}

.floor {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 40%;
  background: #dcdcdc;
  clip-path: polygon(0 40%, 50% 20%, 100% 40%, 100% 100%, 0 100%);
}

.window {
  position: absolute;
  top: 14%;
  left: 8%;
  width: 26%;
  height: 26%;
  background: #eaf6f8;
  border: 3px solid #fff;
  box-shadow: 0 0 0 2px #55c0dc;
}

.mullion-v,
.mullion-h {
  position: absolute;
  background: #fff;
}

.mullion-v {
  left: 50%;
  top: 0;
  width: 3px;
  height: 100%;
  transform: translateX(-50%);
}

.mullion-h {
  top: 50%;
  left: 0;
  height: 3px;
  width: 100%;
  transform: translateY(-50%);
}

.bookshelf {
  position: absolute;
  top: 20%;
  right: 6%;
  width: 20%;
  height: 34%;
  background: #b47b56;
  border: 2px solid #8a5a3b;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  padding: 4px;
}

.bookshelf span {
  height: 2px;
  background: #8a5a3b;
}

.bed {
  position: absolute;
  bottom: 12%;
  left: 12%;
  width: 34%;
  height: 20%;
  background: #fff;
  border: 2px solid #737373;
  border-radius: 4px;
}

.pillow {
  position: absolute;
  top: 8%;
  left: 6%;
  width: 26%;
  height: 60%;
  background: #eaf6f8;
  border-radius: 4px;
}

.blanket {
  position: absolute;
  bottom: 0;
  right: 0;
  width: 60%;
  height: 70%;
  background: #55c0dc;
  border-radius: 4px 0 0 0;
}

.rug {
  position: absolute;
  bottom: 6%;
  left: 42%;
  width: 32%;
  height: 12%;
  background: #eaf6f8;
  border-radius: 999px;
  opacity: 0.8;
}

.plant {
  position: absolute;
  bottom: 10%;
  right: 10%;
  font-size: 26px;
}
</style>
