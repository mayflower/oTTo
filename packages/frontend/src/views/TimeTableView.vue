<template>
  <div class="container mx-auto px-6">
    <div class="flex justify-between h-10 items-center my-4">
      <div>Montag</div>
      <div>Dienstag 21. März 2023</div>
      <div>Mittwoch</div>
    </div>
    <div class="relative mt-16">
      <TimelineComponent :start="timelineStart" :end="timelineEnd" />
      <div class="absolute flex w-full pr-14 -top-14">
        <div class="flex-1 p-2" v-for="room in rooms" :key="room.name">
          <div>
            <div class="bg-slate-600 p-2 rounded-md text-center">{{ room.name }}</div>
          </div>
        </div>
      </div>
      <div class="absolute flex w-full pr-14 top-0">
        <div class="flex-1 px-2" v-for="room in rooms" :key="room.name">
          <div class="relative">
            <TimetableSlotComponent
              class="w-full bg-red-500 p-2 rounded-md absolute"
              :style="{
                height: session.duration * 3 - 0.2 + 'rem',
                top: session.start * 3 + 'rem',
                backgroundColor: room.color
              }"
              v-for="session in room.sessions"
              :key="session.name"
              :title="session.name"
              :host="session.host"
              :room="room.name"
              start="10.00"
              end="11.00"
            >
            </TimetableSlotComponent>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import TimetableSlotComponent from '@/components/TimetableSlotComponent.vue'
import { getRooms } from '@/api/sessions'
import TimelineComponent from '@/components/TimelineComponent.vue'

const timelineStart = new Date(2023, 2, 27, 11)
const timelineEnd = new Date(2023, 2, 27, 16)

const rooms = getRooms()
</script>
