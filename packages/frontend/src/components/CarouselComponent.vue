<template>
  <swiper
    :slides-per-view="4"
    :space-between="spaceBetween"
    :centered-slides="true"
    :breakpoints="{
      768: {
        slidesPerView: 3
      }
    }"
    :navigation="true"
    @slide-change="onSlideChange"
  >
    <slot />
  </swiper>
</template>

<script setup lang="ts">
import { Swiper } from 'swiper/vue'

const spaceBetween = 10
// const onProgress = (e: any) => {
//   const [swiper, progress] = e.detail
// }

const onSlideChange = (e: any) => {
  console.log('slide changed')
}
</script>
