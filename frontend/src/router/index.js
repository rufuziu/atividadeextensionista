import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('@/views/home/HomeView.vue')
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('@/views/about/AboutView.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/views/register/RegisterView.vue')
    },
    {
      path: '/helpus',
      name: 'helpus',
      component: () => import('@/views/helpus/HelpUsView.vue')
    },
    {
      path: '/exercises',
      name: 'exercises',
      component: () => import('@/views/exercises/ExercisesView.vue')
    },
    {
      path: '/exercises/:course',
      name: 'exercises course',
      component: () => import('@/views/exercises/ExercisesCourseView.vue')
    },
    {
      path: '/user',
      name: 'user',
      component: () => import('@/views/user/UserView.vue')
    },
    {
      path: '/user/feedback',
      name: 'user feedback',
      component: () => import('@/views/user/UserFeedbackView.vue')
    },
    {
      path: '/lessons',
      name: 'lessons',
      component: () => import('@/views/lessons/LessonsView.vue')
    },
    {
      path: '/lessons/:course',
      name: 'lessons course',
      component: () => import('@/views/lessons/LessonsCourseView.vue')
    },
    {
      path: '/questions',
      name: 'questions',
      component: () => import('@/views/questions/QuestionsView.vue')
    }
  ]
})

export default router
