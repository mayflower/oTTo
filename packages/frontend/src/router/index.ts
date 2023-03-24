import { createRouter, createWebHistory } from 'vue-router'
import TimeTableView from '@/views/TimeTableView.vue'
import NewSessionView from '@/views/NewSessionView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'timeTable',
      component: TimeTableView
    },
    {
      path: '/addSession',
      name: 'newSession',
      component: NewSessionView
    },
  ]
})

export default router
