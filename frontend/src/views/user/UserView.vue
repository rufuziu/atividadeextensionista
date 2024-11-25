<template>
    <main style="background-color: #f5f5dc;" class="full-height flex justify-center items-center q-gutter-y-md">
        <div id="info-form" class="flex q-gutter-x-lg justify-around">
            <div class="form-img">
                <q-avatar style="background-color: #98ff98; width:200px; height: 200px; cursor:pointer"
                    text-color="white" icon="account_circle" @click="openFileSelect()" />
                <q-file class="img-user invisible" v-model="file" label="Standard" />
            </div>
            <div class="form-data">

                <q-input v-model="user.name" type="text" label="Nome Completo" />
                <q-input v-model="user.email" type="text" label="E-mail" />
                <q-input v-model="user.password" type="password" label="Senha" />
                <q-input v-model="user.confirmPassword" type="password" label="Confirmação de Senha" />
                <p>Tipo de conta: {{ filteredRole}}</p>
            </div>
            <q-btn label="Atualizar" style="background-color: #98ff98; width: 100%;" class="q-mt-sm text-black"
                @click="clog(user)" />
        </div>
    </main>
</template>

<script setup>
import { ref, onMounted, computed } from 'vue';
import JwtService from '../../services/jwt/JwtService';

let roles = ref([
    {
        role: 'ROLE_ADMIN',
        label: 'Admin'
    },
    {
        role: 'ROLE_TEACHER',
        label: 'Professor'
    },
    {
        role: 'ROLE_STUDENT',
        label: 'Estudante'
    },
])

let user = ref({
    name: '',
    email: '',
    password: '',
    confirmPassword: '',
    roles: ''
})

onMounted(() => {
    const userData = localStorage.getItem("token")
    if (userData) {
        user.value.roles = JwtService.decodeToken(userData).role
        user.value.email = JwtService.decodeToken(userData).email
    }
})

const filteredRole = computed(() => {
  return roles.value.filter(item => item.role.includes(user.value.roles))[0].label
})

let file = null

const openFileSelect = () => document.getElementsByClassName('img-user')[0].click()
</script>

<style scoped></style>