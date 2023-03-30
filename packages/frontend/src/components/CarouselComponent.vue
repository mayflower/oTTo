<template>
  <swiper
    :slides-per-view="roomsDisplayed"
    :navigation="true"
    @slide-change="onSlideChange"
  >
    <slot />
  </swiper>
</template>

<script setup lang="ts">
import { Swiper } from 'swiper/vue'

defineProps(['roomsDisplayed'])

const onSlideChange = (e: any) => {
  console.log('slide changed')
}
</script>
