<template>
    <main class="full-height flex q-gutter-x-md">
        <div id="info" class="text-center" style="width: 40%;">
            <h4>Junte-se à comunidade</h4>
            <h5>Reforço Ensino Básico WEB</h5>
            <ul style="list-style-type: none;">
                <li>Dúvidas em alguma matéria -- faça uma pergunta</li>
                <li>Comente em dúvidas (não disponível)</li>
                <li>Salve suas matérias favoritas (não disponível)</li>
                <li>Ganhe pontos resolvendo exercícios (não disponível)</li>
                <li>Outras features (não disponível)</li>
            </ul>
        </div>
        <div id="form" style="width: 50%;">
            <q-input v-model="user.name.value" type="text" label="Nome Completo" />
            <q-input v-model="user.email.value" type="text" label="E-mail" />
            <q-input v-model="user.pwd.value" type="password" label="Senha" />
            <q-input v-model="user.cpwd.value" type="password" label="Confirmação de Senha" />
            <q-radio v-model="user.role.value" val="0">Estudante</q-radio>
            <q-radio v-model="user.role.value" val="1">Professor</q-radio>
            <q-btn label="Registar" style="width: 100%;" class="q-mt-sm text-black" color="orange"
                @click="clog(user)" />
        </div>
    </main>
</template>
  
<script setup>
import { ref } from 'vue';

let user = {
    name: ref(''),
    email: ref(''),
    pwd: ref(''),
    cpwd: ref(''),
    role: ref('')
}

let clog = (x) => console.log(x)
</script>

<style scoped>
main {
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>