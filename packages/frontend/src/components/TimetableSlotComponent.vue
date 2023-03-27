<template>
  <div>
    <span>{{ title }}</span>
    <div>
      <span><fa-icon icon="hat-wizard" />{{ host }}</span>
      <span>{{ host }}</span>
      <span>{{ host }}</span>
      <span>{{ host }}</span>
    </div>
  </div>
</template>

<script setup lang="ts">
defineProps(['title', 'host', 'room', 'start', 'end'])
</script>
