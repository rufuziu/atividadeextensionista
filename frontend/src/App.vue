<template>
  <q-layout view="hHh LpR fff">

    <q-header bordered class="bg-white text-grey-8">
      <q-toolbar>
        <q-btn dense flat icon="menu" @click="toggleLeftDrawer" />

        <q-toolbar-title>
          Reforço Ensino Básico Web
        </q-toolbar-title>

        <q-input rounded outlined dense class="q-mx-lg" style="width:500px;" label="Pesquisar" v-model=text>
          <template v-slot:append>
            <q-icon v-if="text !== ''" name="close" @click="text = ''" class="cursor-pointer" />
            <q-icon name="search" @click="this.$router.push('/questions')" class="cursor-pointer" />
          </template>
        </q-input>

        <q-avatar color="orange" text-color="white" icon="account_circle" @click="toggleRightDrawer" />

      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" class="text-grey-8" side="left" behavior="desktop" overlay bordered>
      <!-- drawer content -->
      <div class="q-ml-md q-mt-sm">
        <RouterLink to="/" class="rlink">
          <p>Home</p>
        </RouterLink>
        <RouterLink to="/register" class="rlink">
          <p>Registre-se</p>
        </RouterLink>
        <RouterLink to="/lessons" class="rlink">
          <p>Lições</p>
        </RouterLink>
        <RouterLink to="/questions" class="rlink">
          <p>Dúvidas</p>
        </RouterLink>
        <RouterLink to="/exercises" class="rlink">
          <p>Exercícios</p>
        </RouterLink>
        <RouterLink to="/about" class="rlink">
          <p>Sobre</p>
        </RouterLink>
        <RouterLink to="/helpus" class="rlink">
          <p>Ajude a causa</p>
        </RouterLink>
      </div>
    </q-drawer>

    <q-drawer v-model="rightDrawerOpen" side="right" behavior="desktop" overlay bordered class="window-height">
      <!-- drawer content -->
      <q-card id="logged-menu" class="window-height" flat>
        <q-btn label="X" :ripple="false" flat color="grey-6" @click="rightDrawerOpen = false" />
        <q-card-section v-if="logged">

          <div id="user-info" class="flex items-center q-gutter-x-md q-my-sm">
            <q-avatar color="orange" text-color="white" icon="account_circle" />
            <p>Usuário</p>
          </div>

          <q-separator />

          <div id="routes" class="q-mt-md">
            <RouterLink to="/user" class="rlink">
              <p>Perfil</p>
            </RouterLink>
            <RouterLink to="/user/feedback" class="rlink">
              <p>Meu feedback</p>
            </RouterLink>
            <RouterLink to="/" @click="logged=false" class="rlink">
              <p>Logout</p>
            </RouterLink>
          </div>

        </q-card-section>

        <q-card-section class="q-mt-xl" v-else>
          <q-input label="E-mail" />
          <q-input label="Senha" />
          <q-btn label="Logar" class="full-width q-mt-sm bg-orange text-black" @click="logged = true" />
          <q-btn label="Esqueci a senha" flat class="full-width q-mt-sm text-orange" />
        </q-card-section>
      </q-card>
    </q-drawer>

    <q-page-container class="window-height">
      <router-view @openRightDrawer="rightDrawerOpen = true" />
    </q-page-container>

  </q-layout>
</template>

<script setup>
import { ref } from 'vue'
import { RouterLink, RouterView } from 'vue-router'

const leftDrawerOpen = ref(false)
const rightDrawerOpen = ref(false)
const text = ref("")
let logged = ref(false)

function toggleLeftDrawer() {
  leftDrawerOpen.value = !leftDrawerOpen.value
}
function toggleRightDrawer() {
  rightDrawerOpen.value = !rightDrawerOpen.value
}
</script>

<style>
.rlink {
  color: black;
  text-decoration: none;
}

.rlink:hover {
  color: orange;
}
</style>