<template>
  <div class="container mx-auto">
    <div class="flex justify-between h-10 items-center my-4">
      <div>Montag</div>
      <div>Dienstag 21. März 2023</div>
      <div>Mittwoch</div>
    </div>
    <div class="relative mt-16">
      <div
        v-for="time in times"
        :key="time.toString()"
        class="border-t border-slate-600 flex justify-end items-center h-12 bg-slate-900 p-3 text-sm text-slate-300"
        :class="{ 'border-t-2': time.getMinutes() === 0 }"
      >
        {{ time.toLocaleTimeString('de-DE', { hour: '2-digit', minute: '2-digit' }) }}
      </div>
      <div class="absolute flex w-full pr-14 -top-14">
        <div class="flex-1 p-2" v-for="item in [0, 1, 2]" :key="item">
          <div>
            <div class="bg-slate-600 p-2 rounded-md text-center">header</div>
          </div>
        </div>
      </div>
      <div class="absolute flex w-full pr-14 top-0">
        <div class="flex-1 px-2" v-for="item in [0, 1, 2]" :key="item">
          <div class="relative">
            <div
              class="w-full bg-red-500 p-2 rounded-md h-[9rem] absolute"
              :style="`height: ${session.duration * 3}rem; top: ${session.start * 3}rem`"
              v-for="session in sessions"
              :key="session.name"
            >
              timeslot
            </div>
          </div>
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

const sessions = [
  {
    name: 'coole session',
    start: 0,
    duration: 3
  },
  {
    name: 'coole session',
    start: 4,
    duration: 1
  }
]
</script>
