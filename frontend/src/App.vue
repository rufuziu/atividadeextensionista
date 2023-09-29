<template>
  <q-layout view="hHh LpR fff">

    <q-header bordered class="bg-white text-grey-8">
      <q-toolbar>
        <!-- <div class="full-width flex justify-between items-center content-center"> -->
        <q-btn dense flat icon="menu" @click="toggleLeftDrawer" />

        <q-toolbar-title>
          Reforço Ensino Básico WEB
        </q-toolbar-title>

        <q-input rounded outlined dense style="width:500px;" label="Pesquisar" v-model=text>
          <template v-slot:append>
            <q-icon v-if="text !== ''" name="close" @click="text = ''" class="cursor-pointer" />
            <q-icon name="search" />
          </template>
        </q-input>

        <!-- </div> -->

      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" class="text-grey-8" side="left" behavior="desktop" overlay bordered>
      <!-- drawer content -->
      <RouterLink to="/"><p>Home</p></RouterLink>
      <RouterLink to="/about"><p>About</p></RouterLink>
      <RouterLink to="/"><p>Register</p></RouterLink>
      <RouterLink to="/"><p>Make-it grow</p></RouterLink>
    </q-drawer>

    <q-drawer v-model="rightDrawerOpen" side="right" behavior="desktop" overlay bordered>
      <!-- drawer content -->
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>

  </q-layout>
</template>

<script>
import { ref } from 'vue'
import { RouterLink, RouterView } from 'vue-router'

export default {
  setup() {
    const leftDrawerOpen = ref(false)
    const rightDrawerOpen = ref(false)
    const text = ref("")
    return {
      text,
      leftDrawerOpen,
      toggleLeftDrawer() {
        leftDrawerOpen.value = !leftDrawerOpen.value
      },

      rightDrawerOpen,
      toggleRightDrawer() {
        rightDrawerOpen.value = !rightDrawerOpen.value
      }
    }
  }
}
</script>