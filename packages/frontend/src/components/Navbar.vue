<template>
  <div class="bg-gray-900 border-b-1 border-gray-600">
    <nav class="container px-6 pt-4 mx-auto">
      <div class="flex items-center justify-between pb-4">
        <router-link to="/" class="text-xl font-bold text-gray-100 hover:text-orange-400  md:text-2xl">oTTo</router-link>
        <a @click="toggleNav" class="flex" href="#">
          <div id="hamburger-icon" title="Menu" :class="{ active: showMenu }">
            <span class="line line-1"></span>
            <span class="line line-2"></span>
            <span class="line line-3"></span>
          </div>
        </a>
      </div>
      <!-- Change max-height when adding new menu points -->
      <ul
        :class="showMenu ? 'max-h-40 pb-1' : 'max-h-0'"
        class="flex flex-col items-center transition-max-height duration-300 overflow-hidden"
      >
        <router-link
          :to="`${item.route}`"
          @click="toggleNav"
          class="text-gray-100 hover:text-orange-400 py-2.5 cursor-pointer text-center block w-full border-t border-gray-700 transition duration-0 hover:duration-300"
          v-for="item in menuItems"
        >
          {{ item.name }}
        </router-link>
      </ul>
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
  },
  {
    route: '',
    name: 'Adminbereich'
  },
]
let showMenu = ref(false)
const toggleNav = () => (showMenu.value = !showMenu.value)
</script>
