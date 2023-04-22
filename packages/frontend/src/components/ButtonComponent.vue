<template>
  <button class="bg-orange-600 hover:bg-orange-700 border-b-orange-700 border-b-2 text-white font-medium text-sm py-2 px-6 rounded-sm">
    {{ text }}
  </button>
</template>

<script setup lang="ts">

defineProps(['text'])

</script>