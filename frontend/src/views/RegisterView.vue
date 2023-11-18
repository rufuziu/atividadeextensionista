<template>
    <main>
        <div id="info" class="text-center" style="width: 50%;">
            <h4 >Junte-se à comunidade Reforço Ensino Básico Online</h4>
            <ul class="">
                <li>Dúvidas em alguma matéria -- faça uma pergunta</li>
                <li>Comente em dúvidas (não disponível)</li>
                <li>Salve suas matérias favoritas (não disponível)</li>
                <li>Ganhe pontos resolvendo exercícios (não disponível)</li>
                <li>Outras features (não disponível)</li>
            </ul>
        </div>
        <div id="form" style="width: 50%;">
            <q-input v-model="text" type="text" label="Label" />
            <q-input v-model="text" type="text" label="Label" />
            <q-input v-model="text" type="text" label="Label" />
            <q-input v-model="text" type="text" label="Label" />
            <q-input v-model="text" type="text" label="Label" />
        </div>
    </main>
</template>
  
<script setup>
</script>

<style scoped>
main {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 32px;
}
</style>