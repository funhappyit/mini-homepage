<script setup lang="ts">
import miniroomImage from '../assets/miniroom-pixel.png'
// CSS/SVG로 간이 표현한 아이소메트릭 미니룸 (실제 이미지 파일 미사용)
</script>

<template>
  <div class="room-scene">
    <img class="room-image" :src="miniroomImage" alt="파란 침대와 책장이 있는 미니룸" />
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
  aspect-ratio: 2.24 / 1;
  margin: 0 auto;
  background: #fff;
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
  background: #d7e5ec;
  clip-path: polygon(0 10%, 100% 0, 100% 100%, 0 90%);
}

.wall-right {
  right: 0;
  background: #c6dce7;
  clip-path: polygon(0 0, 100% 10%, 100% 90%, 0 100%);
}

.floor {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 40%;
  background: #d9d9d9;
  clip-path: polygon(0 40%, 50% 20%, 100% 40%, 100% 100%, 0 100%);
}

.window {
  position: absolute;
  top: 14%;
  left: 8%;
  width: 26%;
  height: 26%;
  background: #edf6f8;
  border: 4px solid #fff;
  box-shadow: 0 0 0 3px #72bedb;
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
  background: #aa805f;
  border: 3px solid #825e43;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  padding: 4px;
}

.bookshelf span {
  height: 3px;
  background: #825e43;
}

.bed {
  position: absolute;
  bottom: 12%;
  left: 12%;
  width: 34%;
  height: 20%;
  background: #fff;
  border: 3px solid #707070;
  border-radius: 6px;
}

.pillow {
  position: absolute;
  top: 8%;
  left: 6%;
  width: 26%;
  height: 60%;
  background: #edf6f8;
  border-radius: 6px;
}

.blanket {
  position: absolute;
  bottom: 0;
  right: 0;
  width: 60%;
  height: 70%;
  background: #79b9d6;
  border-radius: 7px 0 0 0;
}

.rug {
  position: absolute;
  bottom: 6%;
  left: 42%;
  width: 32%;
  height: 12%;
  background: #eff8fa;
  border-radius: 999px;
  opacity: 0.8;
}

.plant {
  position: absolute;
  bottom: 10%;
  right: 10%;
  font-size: clamp(22px, 2.2vw, 34px);
}

.room-image {
  display: block;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.room-scene > :not(.room-image) {
  display: none;
}
</style>
