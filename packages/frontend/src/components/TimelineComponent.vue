<template>
  <div>
    <div
      v-for="time in times"
      :key="time.toString()"
      class="border-neutral-600 flex justify-end items-center h-12 bg-neutral-800 p-3 text-sm text-neutral-300"
      :class="[time.getMinutes() === 0 ? 'border-t-2' : 'border-t text-xs text-neutral-500']"
    >
      {{
        time.getMinutes() === 0
          ? time.toLocaleTimeString('de-DE', { hour: '2-digit', minute: '2-digit' })
          : ':' + time.toLocaleTimeString('de-DE', { minute: '2-digit' })
      }}
    </div>
  </div>
  <div class="z-10 absolute h-0.5 bg-neutral-100 w-full" :style="`top: ${timelineToNowDiff}rem`">
    <div class="h-3.5 aspect-square rounded-full bg-neutral-100 -mt-1.5 -ml-2"></div>
  </div>
</template>

<script setup lang="ts">
import { eachMinuteOfInterval, differenceInMinutes } from 'date-fns'
import { computed, onUnmounted, ref } from 'vue'

const props = defineProps(['start', 'end'])

function generateTimelineArray() {
  const result = eachMinuteOfInterval(
    {
      start: props.start,
      end: props.end
    },
    { step: 15 }
  )
  return result
}
const times = generateTimelineArray()

const now = ref(new Date())

const interval = setInterval(() => {
  const newDate = new Date()
  if (newDate.getSeconds() === 0) {
    now.value = newDate
  }
}, 1000)

const timelineToNowDiff = computed(() => {
  const diff = differenceInMinutes(now.value, props.start)
  const remDistance = (3 / 15) * diff
  return remDistance
})

onUnmounted(() => {
  clearInterval(interval)
})
</script>
