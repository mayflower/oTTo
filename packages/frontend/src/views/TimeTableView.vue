<template>
  <div class="container mx-auto px-6">
    <div class="flex justify-between h-10 items-center my-4">
      <div>Montag</div>
      <div>Dienstag 21. März 2023</div>
      <div>Mittwoch</div>
    </div>
    <div class="flex w-full">
      <div class="flex-1 p-2 pr-0 flex w-full">
        <RoomDropdownComponent
          :rooms="rooms"
          :selected-room-index="selectedRoom"
          @on-room-click="(data) => changeRoom(data)"
          class="flex-1"
          v-if="roomsDisplayed === 1"
        >
          <div class="flex-1">{{ rooms[selectedRoom].name }}</div>

          <fa-icon
            icon="fa fa-chevron-down"
            class="h-4 w-4 text-white absolute right-3 bottom-1/2 top-1/2 -translate-y-1/2"
            aria-hidden="true"
          />
        </RoomDropdownComponent>
        <div v-else class="flex w-full gap-4">
          <div
            v-for="roomIndex in roomDisplayedRange"
            :key="roomIndex"
            class="rounded-md flex-1 text-center bg-black bg-opacity-20 px-4 py-2 text-sm font-medium text-white hover:bg-opacity-30 focus:outline-none focus-visible:ring-2 focus-visible:ring-white focus-visible:ring-opacity-75"
          >
            {{ rooms[roomIndex].name }}
          </div>
        </div>
        <button
          @click="paginateRooms(-1)"
          class="px-2 py-1 h-1"
          :class="{ 'opacity-60': !canGoLeft }"
          :disabled="!canGoLeft"
        >
          <fa-icon icon="fa fa-circle-chevron-left"></fa-icon>
        </button>
        <button
          @click="paginateRooms(1)"
          class="px-2 py-1 h-1"
          :class="{ 'opacity-60': !canGoRight }"
          :disabled="!canGoRight"
        >
          <fa-icon icon="fa fa-circle-chevron-right"></fa-icon>
        </button>
      </div>
    </div>
    <div data-simplebar :style="{ height: 'calc(100vh - 250px)' }" class="-ml-3">
      <div class="relative ml-3" v-resize="onTimelineResize">
        <TimelineComponent :start="timelineStart" :end="timelineEnd" />

        <div class="absolute w-full flex pr-14 top-0 h-full">
          <CarouselComponent id="swiper" :rooms-displayed="roomsDisplayed" class="w-full pr-14 top-0">
            <swiper-slide v-for="room in rooms" :key="room.name" class="px-2">
              <div class="relative w-full h-full">
                <TimetableSlotComponent
                  class="w-full bg-red-500 p-2 rounded-md mt-0.5 absolute"
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
            </swiper-slide>
          </CarouselComponent>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import TimetableSlotComponent from '@/components/TimetableSlotComponent.vue'
import { getRooms } from '@/api/sessions'
import TimelineComponent from '@/components/TimelineComponent.vue'
import { computed, ref } from 'vue'
import RoomDropdownComponent from '@/components/RoomDropdownComponent.vue'
import CarouselComponent from '@/components/CarouselComponent.vue'
import { SwiperSlide } from 'swiper/vue'

const timelineStart = new Date(2023, 2, 29, 8)
const timelineEnd = new Date(2023, 2, 29, 18)

const selectedRoom = ref(0)

function changeRoom(index: number) {
  selectedRoom.value = index
}

const rooms = getRooms()

const canGoLeft = computed(() => selectedRoom.value !== 0)
const canGoRight = computed(() => rooms.length !== selectedRoom.value + roomsDisplayed.value)

function paginateRooms(direction: -1 | 1) {
  if (!canGoLeft.value && direction === -1) return
  if (!canGoRight.value && direction === 1) return

  if (direction === 1) {
    const swiper = (document.getElementById("swiper") as any).swiper
    swiper.slideNext()
  }

  if (direction === -1) {
    const swiper = (document.getElementById("swiper") as any).swiper
    swiper.slidePrev()
  }

  selectedRoom.value = selectedRoom.value + direction
}

const roomsDisplayed = ref(1)

function generateRange(start: number, end: number): number[] {
  return Array.from({ length: end - start }, (_, i) => start + i)
}

const roomDisplayedRange = computed(() => {
  const firstIndex = selectedRoom.value
  const lastIndex = selectedRoom.value + roomsDisplayed.value

  const arr = generateRange(firstIndex, lastIndex)

  return arr
})

function onTimelineResize(sizes: { width: number }) {
  const minRoomWidth = 275
  const roomsDisplayedNew = Math.floor(sizes.width / minRoomWidth) || 1

  if (!canGoRight.value) {
    const lastPossible =
      selectedRoom.value + roomsDisplayedNew - (selectedRoom.value + roomsDisplayed.value)
    selectedRoom.value = selectedRoom.value - lastPossible
  }

  roomsDisplayed.value = roomsDisplayedNew
}
</script>