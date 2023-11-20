<template>
  <q-layout view="hHh LpR fff">

    <q-header bordered class="bg-white text-grey-8">
      <q-toolbar>
        <q-btn dense flat icon="menu" @click="toggleLeftDrawer" />

        <q-toolbar-title>
          Reforço Ensino Básico WEB
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
        <RouterLink to="/questions" class="rlink">
          <p>Perguntas</p>
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

    <q-drawer v-model="rightDrawerOpen" side="right" behavior="desktop" overlay bordered
    class="window-height flex justify-center items-center"
    >
      <!-- drawer content -->
      <div v-if="login" class="q-ml-md q-mt-sm">
        <!-- acesso do usuário -->
      </div>
      <div v-else class="q-ml-md q-mt-sm">
        <!-- login -->
        <q-input label="E-mail"/>
        <q-input label="Senha"/>
        <q-btn label="Logar" class="full-width q-mt-sm bg-orange text-black"/>
        <q-btn label="Esqueci a senha" flat class="full-width q-mt-sm text-orange"/>
      </div>
    </q-drawer>

    <q-page-container class="window-height">
      <router-view />
    </q-page-container>

  </q-layout>
</template>

<script setup>
import { ref } from 'vue'
import { RouterLink, RouterView } from 'vue-router'

const leftDrawerOpen = ref(false)
const rightDrawerOpen = ref(false)
const text = ref("")
let login = ref(false)

function toggleLeftDrawer() {
  leftDrawerOpen.value = !leftDrawerOpen.value
}
function toggleRightDrawer() {
  rightDrawerOpen.value = !rightDrawerOpen.value
}
</script>

<style>
.rlink{
  color:black;
  text-decoration: none;
}
.rlink:hover{
  color:orange;
}
</style>