import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import 'simplebar'
import 'simplebar/dist/simplebar.css'
import { register } from 'swiper/element/bundle'
import App from './App.vue'
import router from './router'

import './assets/main.css'
import 'swiper/css'
import { initializeIcons } from './icons'

const app = createApp(App)

app.directive('resize', {
  mounted: function (el: HTMLElement, binding) {
    const onResizeCallback = binding.value
    new ResizeObserver(() => {
      const width = el.clientWidth
      const height = el.clientHeight
      onResizeCallback({ width, height })
    }).observe(el)
  }
})

app.directive('click-outside', {
  beforeMount: (el, binding) => {
    el.clickOutsideEvent = (event: any) => {
      if (!(el == event.target || el.contains(event.target))) {
        binding.value()
      }
    }
    document.addEventListener('click', el.clickOutsideEvent)
  },
  unmounted: (el) => {
    document.removeEventListener('click', el.clickOutsideEvent)
  }
})

register()

app.use(createPinia())
app.use(router)

app.component('fa-icon', FontAwesomeIcon)
initializeIcons()

app.mount('#app')
