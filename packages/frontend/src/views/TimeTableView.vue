<template>
  <div class="container mx-auto">
    <div class="flex justify-between h-10 items-center my-4">
      <div>Montag</div>
      <div>Dienstag 21. März 2023</div>
      <div>Mittwoch</div>
    </div>
    <div class="relative">
      <div
        v-for="time in times"
        :key="time.toString()"
        class="border-t border-slate-600 flex justify-end items-center h-12 bg-slate-900 p-3 text-sm text-slate-300"
        :class="{ 'border-t-2': time.getMinutes() === 0 }"
      >
        {{ time.toLocaleTimeString('de-DE', { hour: '2-digit', minute: '2-digit' }) }}
      </div>
      <div class="absolute top-0 bg-red-400">
        <div>
            test
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { eachMinuteOfInterval } from 'date-fns'
function generateTimelineArray() {
  const result = eachMinuteOfInterval(
    {
      start: new Date(2014, 9, 14, 13),
      end: new Date(2014, 9, 14, 16, 3)
    },
    { step: 15 }
  )

  return result
}
const times = generateTimelineArray()
</script>
