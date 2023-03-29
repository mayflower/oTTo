<template>
  <Menu as="div" class="relative">
    <div>
      <MenuButton v-slot="{ open }" class="w-full">
        <div
          class="w-full bg-black bg-opacity-20 px-4 py-2 text-sm font-medium text-white hover:bg-opacity-30 focus:outline-none focus-visible:ring-2 focus-visible:ring-white focus-visible:ring-opacity-75"
          :class="[open ? 'rounded-t-md' : 'rounded-md']"
        >
          <slot />
        </div>
      </MenuButton>
    </div>

    <transition
      enter-active-class="transition duration-100 ease-out"
      enter-from-class="transform  opacity-0"
      enter-to-class="transform  opacity-100"
      leave-active-class="transition duration-75 ease-in"
      leave-from-class="transform  opacity-100"
      leave-to-class="transform  opacity-0"
    >
      <MenuItems
        class="absolute z-50 w-full origin-top-right divide-y divide-neutral-500 rounded-b-md bg-neutral-700 shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none overflow-hidden"
      >
        <MenuItem
          v-slot="{ active }"
          v-for="(room, index) in rooms"
          :key="index"
          v-show="index !== selectedRoomIndex"
        >
          <button
            :class="[
              { 'bg-neutral-500': active },
              'group flex w-full items-center  py-2 text-sm justify-center text-white'
            ]"
            @click="roomSelected(index)"
          >
            {{ room.name }}
          </button>
        </MenuItem>
      </MenuItems>
    </transition>
  </Menu>
</template>

<script setup lang="ts">
import { Menu, MenuButton, MenuItems, MenuItem } from '@headlessui/vue'

const props = defineProps(['rooms', 'selectedRoomIndex'])

const emit = defineEmits(['onRoomClick'])

function roomSelected(index: number) {
  emit('onRoomClick', index)
}
</script>
