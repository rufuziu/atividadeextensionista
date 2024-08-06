<template>
  <q-layout view="hHh LpR fff" >

    <q-header bordered style="background-color: #003366; color: #f5f5dc;">
      <q-toolbar>
        <q-btn dense flat icon="menu" @click="toggleLeftDrawer" />

        <q-toolbar-title>
          Reforço Online
        </q-toolbar-title>


          <q-input  dense class="q-mx-lg" style="width:500px;  background-color: #f5f5dc" label="Pesquisar"  v-model=text>
            <template v-slot:append>
              <q-icon v-if="text !== ''" name="close" @click="text = ''" class="cursor-pointer" />
              <q-icon name="search" @click="this.$router.push('/questions')" class="cursor-pointer" />
            </template>
          </q-input>

        <q-avatar style="background-color: #98ff98;" text-color="white" icon="account_circle" @click="toggleRightDrawer" />

      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" style="background-color: #003366; color:#f5f5dc" side="left" behavior="desktop" overlay bordered>
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

    <q-drawer v-model="rightDrawerOpen" style="background-color: #003366; color:#f5f5dc;" side="right" behavior="desktop" overlay bordered class="window-height">
      <!-- drawer content -->
      <q-card id="logged-menu" style="background-color: #003366; color:#f5f5dc;" class="window-height" flat>
        <q-btn label="X" :ripple="false" flat style="color: #f5f5dc;" @click="rightDrawerOpen = false" />
        <q-card-section v-if="logged">

          <div id="user-info" class="flex items-center q-gutter-x-md q-my-sm">
            <q-avatar style="background-color: #98ff98;" text-color="white" icon="account_circle" />
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

        <q-card-section class="q-mt-xl q-gutter-xs" v-else>
          <q-input style="background-color: #f5f5dc;" class="full-width" label="E-mail" />
          <q-input style="background-color: #f5f5dc;" class="full-width" label="Senha" />
          <q-btn label="Logar" style="background-color: #d3d3d3;" class="full-width q-mt-sm text-black" @click="logged = true" />
          <q-btn label="Criar uma conta" style="background-color: #add8e6" class="full-width q-mt-sm text-black" @click="logged = true" />
          <q-btn label="Esqueci a senha" style="color: #98ff98;" flat class="full-width q-mt-sm" />
        </q-card-section>
      </q-card>
    </q-drawer>

    <q-page-container class="window-height" style="margin:0; padding:0;">
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
  color: #f5f5dc;
  text-decoration: none;
}

.rlink:hover {
  color: #add8e6;
}
</style>