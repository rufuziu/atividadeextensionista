<script setup>
import { ref, onMounted, computed } from 'vue'
import { RouterLink, RouterView } from 'vue-router'
import router from './router';
import AuthService from './services/AuthService';
import JwtService from './services/JwtService';


let menu = ref([
  {
    label: 'Perfil',
    to: '/user',
    roles: ['ROLE_ADMIN', 'ROLE_TEACHER', 'ROLE_STUDENT']
  },
  {
    label: 'Painel Professor',
    to: '/user/teacher',
    roles: ['ROLE_TEACHER']
  },
  {
    label: 'Painel Admin',
    to: '/user/admin',
    roles: ['ROLE_ADMIN']
  },
  {
    label: 'Meu feedback',
    to: '/user/feedback',
    roles: ['ROLE_ADMIN', 'ROLE_TEACHER', 'ROLE_STUDENT']
  },
  {
    label: 'Logout',
    to: '/',
    roles: ['ROLE_ADMIN', 'ROLE_TEACHER', 'ROLE_STUDENT'],
    func: function logoutUser() {
      localStorage.clear();
      logged.value = false
    }
  }
])

const filteredMenu = computed(() => {
  return menu.value.filter(item => item.roles.includes(user.value.roles))
})

let logged = ref(false)
const text = ref("")

onMounted(() => {
  const userData = localStorage.getItem("token")
  if (userData) {
    logged.value = true
    console.log("token válida")
    user.value.roles = JwtService.decodeToken(userData).role
    user.value.email = JwtService.decodeToken(userData).email
    console.log(user)
  }
})

const leftDrawerOpen = ref(false)
const rightDrawerOpen = ref(false)

let user = ref({
  email: '',
  password: '',
  token: '',
  roles: ''
})

const authUser = async (user) => {
  AuthService.authUser(user)
    .then(response => {
      switch (response.status) {
        case 200:
          localStorage.setItem('token', response.data.token)
          logged.value = true
          user.roles = JwtService.decodeToken(response.data.token).role
          user.email = JwtService.decodeToken(response.data.token).email
          break;
      }

    })
    .catch(error => {
      console.error(error)
    })
}

function toggleLeftDrawer() {
  leftDrawerOpen.value = !leftDrawerOpen.value
}
function toggleRightDrawer() {
  rightDrawerOpen.value = !rightDrawerOpen.value
}
</script>

<template>
  <q-layout view="hHh LpR fff">

    <q-header style="background-color: #003366; color: #f5f5dc;">
      <q-toolbar>
        <q-btn dense flat icon="menu" @click="toggleLeftDrawer" />

        <q-toolbar-title>
          Reforço Online
        </q-toolbar-title>


        <q-input filled dense class="q-mx-lg" style="width:500px;  background-color: #f5f5dc" label="Pesquisar"
          v-model=text>
          <template v-slot:append>
            <q-icon v-if="text !== ''" name="close" @click="text = ''" class="cursor-pointer" />
            <q-icon name="search" @click="this.$router.push('/questions')" class="cursor-pointer" />
          </template>
        </q-input>

        <q-avatar style="background-color: #98ff98;" text-color="white" icon="account_circle"
          @click="toggleRightDrawer" />

      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" style="background-color: #003366; color:#f5f5dc" side="left" behavior="desktop"
      overlay bordered>
      <!-- drawer content -->
      <div class="q-ml-md q-mt-sm">
        <RouterLink to="/" class="rlink">
          <p>Home</p>
        </RouterLink>
        <RouterLink to="/classes" class="rlink">
          <p>Aulas</p>
        </RouterLink>
        <RouterLink to="/exercises" class="rlink">
          <p>Exercícios</p>
        </RouterLink>
        <RouterLink to="/questions" class="rlink">
          <p>Dúvidas</p>
        </RouterLink>
        <RouterLink to="/about" class="rlink">
          <p>Sobre</p>
        </RouterLink>
        <RouterLink to="/helpus" class="rlink">
          <p>Ajude a causa</p>
        </RouterLink>
      </div>
    </q-drawer>

    <q-drawer v-model="rightDrawerOpen" style="background-color: #003366; color:#f5f5dc;" side="right"
      behavior="desktop" overlay bordered class="window-height">
      <!-- drawer content -->
      <q-card id="logged-menu" style="background-color: #003366; color:#f5f5dc;" class="window-height" flat>
        <q-btn label="X" :ripple="false" flat style="color: #f5f5dc;" @click="rightDrawerOpen = false" />
        <q-card-section v-if="logged">

          <div id="user-info" class="flex items-center q-gutter-x-md q-my-sm">
            <q-avatar style="background-color: #98ff98;" text-color="white" icon="account_circle" />
            <p>{{ user.email }}</p>
          </div>

          <q-separator />

          <div id="routes" class="q-mt-md">

            <RouterLink v-for="item in filteredMenu" :to="item.to" @click="item.func" class="rlink">
              <p>{{ item.label }}</p>
            </RouterLink>
            <!-- <RouterLink to="/user/feedback" class="rlink">
              <p>Meu feedback</p>
            </RouterLink>
            <RouterLink to="/" @click="logoutUser" class="rlink">
              <p>Logout</p>
            </RouterLink> -->
          </div>

        </q-card-section>

        <q-card-section class="q-mt-xl q-gutter-xs" v-else>
          <q-input filled dense style="background-color: #f5f5dc;" class="full-width" label="E-mail"
            v-model="user.email" />
          <q-input filled dense type="password" style="background-color: #f5f5dc;" class="full-width" label="Senha"
            v-model="user.password" />
          <q-btn label="Logar" style="background-color: #d3d3d3;" class="full-width q-mt-sm text-black"
            @click="authUser(user)" />
          <q-btn label="Criar uma conta" style="background-color: #add8e6" class="full-width q-mt-sm text-black"
            @click="this.$router.push('/register')" />
          <q-btn label="Esqueci a senha" style="color: #98ff98;" flat class="full-width q-mt-sm" />
        </q-card-section>
      </q-card>
    </q-drawer>

    <q-page-container class="window-height"
      style="background-color: #f5f5dc;margin:0; padding:0; box-sizing: border-box;">
      <router-view @openRightDrawer="rightDrawerOpen = true" />
    </q-page-container>

  </q-layout>
</template>

<style>
.rlink {
  color: #f5f5dc;
  text-decoration: none;
}

.rlink:hover {
  color: #add8e6;
}
</style>