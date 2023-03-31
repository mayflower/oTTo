<template>
  <swiper
    :slides-per-view="roomsDisplayed"
    :navigation="true"
    @progress="onProgress"
  >
    <slot />
  </swiper>
</template>

<script setup lang="ts">
import { Swiper } from 'swiper/vue'

defineProps(['roomsDisplayed'])

const emit = defineEmits(["onProgress"])

const onProgress = (e: any) => {
  emit("onProgress", e.progress, e)
}
</script>
