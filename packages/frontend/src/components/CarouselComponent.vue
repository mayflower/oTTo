<template>
  <swiper
    :slides-per-view="4"
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

// const onProgress = (e: any) => {
//   const [swiper, progress] = e.detail
// }

const onSlideChange = (e: any) => {
  console.log('slide changed')
}
</script>
