<template>
  <div
    v-if="!isKeynote"
    class="w-full p-2 rounded-md mt-0.5 absolute"
    :style="{
      height: duration * 3 - 0.2 + 'rem',
      top: sessionStart * 3 + 'rem',
      backgroundColor: room.color
    }"
  >
    <div class="flex flex-col justify-center overflow-hidden">
      <div>
        <span class="text-sm font-bold line-clamp-2">
          {{ isKeynote ? 'KEYNOTE: ' : '' }}
          {{ title }}
        </span>
        <div class="flex flex-col text-xs mt-1">
          <span>
            <fa-icon icon="user" class="text-black opacity-40 w-5" />
            {{ host }}
          </span>
          <span>
            <fa-icon icon="clock" class="text-black opacity-40 w-5" />
            {{ start }} - {{ end }}
          </span>
          <span>
            <fa-icon icon="location-dot" class="text-black opacity-40 w-5" />
            {{ room.name }}
          </span>
        </div>
      </div>
    </div>
  </div>

  <div
    v-if="isKeynote"
    class="w-full mt-0.5 absolute"
    :style="{
      height: duration * 3 - 0.2 + 'rem',
      top: sessionStart * 3 + 'rem'
    }"
  >
    <div class="absolute -left-80 bg-red-500 flex">
      <div class="p-2 rounded-md">
        keynote
      </div>
    </div>
    <div
      class="p-2 rounded-md"
      :style="{
        backgroundColor: room.color
      }"
    >
      <div class="flex flex-col justify-center overflow-hidden">
        <div>
          <span class="text-sm font-bold line-clamp-2">
            {{ isKeynote ? 'KEYNOTE: ' : '' }}
            {{ title }}
          </span>
          <div class="flex flex-col text-xs mt-1">
            <span>
              <fa-icon icon="user" class="text-black opacity-40 w-5" />
              {{ host }}
            </span>
            <span>
              <fa-icon icon="clock" class="text-black opacity-40 w-5" />
              {{ start }} - {{ end }}
            </span>
            <span>
              <fa-icon icon="location-dot" class="text-black opacity-40 w-5" />
              {{ room.name }}
            </span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
defineProps([
  'title',
  'host',
  'room',
  'start',
  'end',
  'duration',
  'sessionStart',
  'isKeynote',
  'index'
])
</script>
