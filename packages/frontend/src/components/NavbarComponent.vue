<template>
  <div class="relative bg-neutral-800 border-b-1 border-neutral-600 z-20">
    <nav class="h-16">
      <div class="container mx-auto px-6 pt-4 flex items-center justify-between pb-4">
        <router-link
          to="/"
          class="text-xl font-bold text-neutral-100 hover:text-orange-400 md:text-2xl"
          >oTTo</router-link
        >
        <a @click="toggleNav" class="flex" href="#">
          <div id="hamburger-icon" title="Menu" :class="{ active: showMenu }">
            <span class="line line-1"></span>
            <span class="line line-2"></span>
            <span class="line line-3"></span>
          </div>
        </a>
      </div>
      <!-- Change max-height when adding new menu points -->
      <div class=" bg-neutral-800">
        <ul
        :class="showMenu ? 'max-h-40 pb-1' : 'max-h-0'"
        class="container mx-auto px-6 flex flex-col items-center transition-max-height duration-300 overflow-hidden"
      >
        <router-link
          active-class="font-bold text-orange-400"
          :to="`${item.route}`"
          @click="toggleNav"
          class="text-neutral-100 hover:text-orange-400 py-2.5 cursor-pointer text-center block w-full border-t border-neutral-700 transition duration-0 hover:duration-300"
          v-for="item in menuItems"
          :key="item.name"
        >
          {{ item.name }}
        </router-link>
      </ul>
      </div>
    </nav>
  </div>
</template>

<script setup lang="ts">
import '../assets/burger-icon.scss'
import { ref } from 'vue'

let menuItems = [
  {
    route: '/',
    name: 'TimeTable'
  },
  {
    route: 'addSession',
    name: 'Neue Session hinzufügen'
  }
]
let showMenu = ref(false)
const toggleNav = () => (showMenu.value = !showMenu.value)
</script>
