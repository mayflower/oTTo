<template>
  <div class="container mx-auto px-6">
    <div class="flex justify-between h-10 items-center my-4">
      <div>Montag</div>
      <div>Dienstag 21. März 2023</div>
      <div>Mittwoch</div>
    </div>
    <div class="flex w-full pr-14">
      <div class="flex-1 p-2">
        <div>
          <RoomDropdownComponent
            :rooms="rooms"
            :selected-room-index="selectedRoom"
            @on-room-click="(data) => changeRoom(data)"
          >
            <div class="flex-1">{{ rooms[selectedRoom].name }}</div>

            <fa-icon
              icon="fa fa-chevron-down"
              class="h-4 w-4 text-white absolute right-3 bottom-1/2 top-1/2 -translate-y-1/2"
              aria-hidden="true"
            />
          </RoomDropdownComponent>
        </div>
      </div>
    </div>
    <div data-simplebar :style="{ height: 'calc(100vh - 250px)' }">
      <div class="relative">
        <TimelineComponent :start="timelineStart" :end="timelineEnd" />

        <div class="absolute flex w-full pr-14 top-0">
          <div class="flex-1 px-2">
            <div class="relative">
              <TimetableSlotComponent
                class="w-full bg-red-500 p-2 rounded-md absolute"
                :style="{
                  height: session.duration * 3 - 0.2 + 'rem',
                  top: session.start * 3 + 'rem',
                  backgroundColor: rooms[selectedRoom].color
                }"
                v-for="session in rooms[selectedRoom].sessions"
                :key="session.name"
                :title="session.name"
                :host="session.host"
                :room="rooms[selectedRoom].name"
                start="10.00"
                end="11.00"
              >
              </TimetableSlotComponent>
            </div>
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
import { ref } from 'vue'
import RoomDropdownComponent from '@/components/RoomDropdownComponent.vue'

const timelineStart = new Date(2023, 2, 27, 8)
const timelineEnd = new Date(2023, 2, 27, 18)

const selectedRoom = ref(0)

function changeRoom(index: number) {
  selectedRoom.value = index
}

const rooms = getRooms()
</script>
