import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import 'simplebar'
import 'simplebar/dist/simplebar.css'

import App from './App.vue'
import router from './router'

import './assets/main.css'
import { initializeIcons } from './icons'

const app = createApp(App)

app.use(createPinia())
app.use(router)

app.component('fa-icon', FontAwesomeIcon)
initializeIcons()

app.mount('#app')
