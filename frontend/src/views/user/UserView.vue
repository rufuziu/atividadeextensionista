<template>
    <main class="full-height flex justify-center items-center q-gutter-y-md">
        <div id="info-form" class="flex q-gutter-x-lg justify-around">
            <div class="form-img">
                <q-avatar style="width:200px; height: 200px; cursor:pointer" color="orange" text-color="white"
                    icon="account_circle" @click="openFileSelect()"/>
                <q-file class="img-user invisible" v-model="file" label="Standard" />
            </div>
            <div class="form-data">

                <q-input v-model="user.name.value" type="text" label="Nome Completo" />
                <q-input v-model="user.email.value" type="text" label="E-mail" />
                <q-input v-model="user.pwd.value" type="password" label="Senha" />
                <q-input v-model="user.cpwd.value" type="password" label="Confirmação de Senha" />
                <q-radio v-model="user.role.value" val="0">Estudante</q-radio>
                <q-radio v-model="user.role.value" val="1">Professor</q-radio>
            </div>
            <q-btn label="Atualizar" style="width: 100%;" class="q-mt-sm text-black" color="orange" @click="clog(user)" />
        </div>
    </main>
</template>
  
<script setup>
import { ref } from 'vue';

let user = {
    name: ref('Usuario 1'),
    email: ref('usuario1@email.com'),
    pwd: ref(''),
    cpwd: ref(''),
    role: ref('0')
}

let file = null

const openFileSelect = () => document.getElementsByClassName('img-user')[0].click()
</script>

<style scoped></style>