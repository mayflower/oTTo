<template>
  <swiper
    :slides-per-view="roomsDisplayed"
    :navigation="true"
  >
    <slot />
  </swiper>
</template>

<script setup lang="ts">
import { Swiper } from 'swiper/vue'

defineProps(['roomsDisplayed'])
</script>
