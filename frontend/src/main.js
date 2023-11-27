import { Quasar } from 'quasar'
import { createApp } from 'vue'
import Dialog from './components/Dialog.vue'
import App from './App.vue'
import router from './router'

const app = createApp(App)
app.component('Dialog',Dialog)

app.use(router).use(Quasar)

app.mount('#app')
