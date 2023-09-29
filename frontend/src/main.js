import { Quasar } from 'quasar'
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(router).use(Quasar)

app.mount('#app')
