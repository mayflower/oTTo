<template>
  <div class="container mx-auto">
    <div class="flex justify-between h-10 items-center my-4">
      <div>Montag</div>
      <div>Dienstag 21. März 2023</div>
      <div>Mittwoch</div>
    </div>
    <div class="relative mt-16">
      <div>
        <div
          v-for="time in times"
          :key="time.toString()"
          class="border-t border-slate-600 flex justify-end items-center h-12 bg-slate-900 p-3 text-sm text-slate-300"
          :class="{ 'border-t-2': time.getMinutes() === 0 }"
        >
          {{ time.toLocaleTimeString('de-DE', { hour: '2-digit', minute: '2-digit' }) }}
        </div>
        <div
          class="absolute h-0.5 bg-slate-100 w-full"
          :style="`top: ${timelineToNowDiff}rem`"
        >
          <div class="h-3.5 aspect-square rounded-full bg-slate-100 -mt-1.5 -ml-2"></div>
        </div>
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
              class="w-full bg-red-500 p-2 rounded-md absolute"
              :style="`height: ${session.duration * 3 - 0.2}rem; top: ${session.start * 3}rem`"
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
import { eachMinuteOfInterval, differenceInMinutes } from 'date-fns'
import { computed, onUnmounted, ref } from 'vue';

const timelineStart = new Date(2023, 2, 27, 11)
const timelineEnd = new Date(2023, 2, 27, 16)

function generateTimelineArray() {
  const result = eachMinuteOfInterval(
    {
      start: timelineStart,
      end: timelineEnd
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
    duration: 4
  },
  {
    name: 'coole session',
    start: 4,
    duration: 1
  }
]

const now = ref(new Date())

const interval = setInterval(()=>{
    const newDate = new Date()
    if (newDate.getSeconds() === 0) {
        now.value = newDate
    }
}, 1000)

const timelineToNowDiff = computed(() => {
    const diff = differenceInMinutes(now.value, timelineStart)
    const remDistance = 3 / 15 * diff
    console.log(diff)
    return remDistance
})

onUnmounted(()=> {
    clearInterval(interval)
})

</script>
