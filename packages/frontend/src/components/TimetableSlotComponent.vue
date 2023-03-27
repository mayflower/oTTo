<template>
  <div class="flex flex-col justify-center overflow-hidden">
    <div>
      <span class="text-sm font-bold line-clamp-2">{{ title }}</span>
      <div class="flex flex-col text-xs mt-1">
        <span>
          <fa-icon icon="user" class="text-black opacity-40 w-5" />
          {{ host }}
        </span>
        <span>
          <fa-icon icon="clock" class="text-black opacity-40 w-5" />
          {{ start }} {{ end }}
        </span>
        <span>
          <fa-icon icon="location-dot" class="text-black opacity-40 w-5" />
          {{ room }}
        </span>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
defineProps(['title', 'host', 'room', 'start', 'end'])
</script>
