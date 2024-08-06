<template>
    <main style="background-color: #f5f5dc;" class="full-height flex">
        <div id="info" class="text-center" style="width: 48%;">
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
        <div id="form" class="row q-gutter-sm justify-center" style="width: 48%;">

            <q-input class="col-9" filled dense v-model="user.name" type="text" label="Nome Completo" />
            <q-input class="col-9" filled dense v-model="user.email" type="text" label="E-mail" />
            <q-input class="col-9" filled dense v-model="user.password" type="password" label="Senha" />
            <q-input class="col-9" filled dense v-model="user.birthday" type="date" label="Data de Nascimento" />

            <div>
                <q-radio v-for="role in roles" :key="role.name" v-model="selectedRole" :val="role"
                    :label="role.label" />
            </div>

            <div class="col-9">
                <q-btn label="Registar" style="background-color: #add8e6;" class="full-width text-black"
                    @click="registerUser(user)" />

            </div>
        </div>

        <q-dialog v-model="registerMessage">
            <q-card>
                <q-card-section>
                    <div class="text-h6">{{ message.title }}</div>
                </q-card-section>

                <q-card-section class="q-pt-none">
                    {{ message.content }}
                </q-card-section>

                <q-card-actions align="right">
                    <q-btn label="OK" style="background-color: #add8e6;" @click="this.$router.push('/')" />
                </q-card-actions>
            </q-card>
        </q-dialog>
    </main>
</template>

<script setup>
import { ref } from 'vue';
import RegisterService from '../../services/RegisterService';


const roles = ref([
    {
        name: 'ROLE_ADMIN',
        label: 'Admin'
    },
    {
        name: 'ROLE_TEACHER',
        label: 'Professor'
    },
    {
        name: 'ROLE_STUDENT',
        label: 'Estudante'
    }
])

let selectedRole = ref(roles.value[0])

let user = ref({
    email: '',
    password: '',
    birthday: '',
    active: false,
    roles: []
})

let message = ref({
    title: '',
    content: ''
})

let registerMessage = ref(false)

const registerUser = async (user) => {

    user.roles.push({ name: selectedRole.value.name })


    await RegisterService.registerUser(user)
        .then(response => {
            console.log(response)
            console.log(response.status)
            switch (response.status) {
                case 201:
                    message.value.title = 'Sucesso!'
                    message.value.content = `
                    O seu registro foi realizado com sucesso e logo chegará na caixa de entrada do seu
                    e-mail um link de ativação da conta.
                    Após a ativação da conta você poderá interagir no Reforço Online.
                    Parabéns!`
                    registerMessage.value = true
                    break;
            }
        })
        .catch(error => {
            console.error(error)
            message.value.title = 'Falha!'
            message.value.content = `Algo aconteceu de errado, tente novamente mais tarde.`
            registerMessage.value = true
        })
        .finally(_ => {
            console.log(_)
        })
}

</script>

<style scoped>
main {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>