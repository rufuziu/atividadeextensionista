<template>
  <main style="background-color: #f5f5dc; height: 100vh;">
    <div id="header" class="flex items-center justify-around">
      <h3>Exercícios da matéria de {{ this.$route.params.course }}</h3>
    </div>
    <div id="content" class="flex justify-center q-mx-lg q-gutter-x-md">
      <div id="filters" style="width:20%">
        <q-card id="filter-card" class="full-width">
          <q-card-section>
            <h4>Conteúdo</h4>
            <q-checkbox label="Morfologia" color="pink" />
            <q-checkbox label="Sintaxe" color="orange" />
            <q-checkbox label="Fonologia/Fonética" color="blue" />
            <q-checkbox label="Semântica" color="green" />
            <q-checkbox label="Estilística" color="brown" />
            <q-checkbox label="Reforma ortográfica" color="yellow" />
          </q-card-section>
        </q-card>
      </div>
      <div id="questions" class="row" style="width: 70%;">
        <div id="col" class="col-12 q-gutter-y-md">
          <q-card class="question">
            <q-item>
              <q-item-section avatar class="items-center">
                <q-avatar color="red" text-color="white" icon="account_circle" />
                <span>Professor A</span>
              </q-item-section>

              <q-item-section>
                <q-item-label>5 questões de múltipla escolha sobre tipos de linguagem</q-item-label>
                <q-item-label caption>1 - A Linguagem está relacionada a fenômenos comunicativos; onde há comunicação, há
                  linguagem... </q-item-label>
              </q-item-section>

            </q-item>
            <div class="q-mx-md q-gutter-x-sm text-left">
              <q-badge rounded color="green" label="Semântica" />
            </div>
          </q-card>
          <q-card class="question">
            <q-item>
              <q-item-section avatar class="items-center">
                <q-avatar color="cyan" text-color="white" icon="account_circle" />
                <span>Professor F</span>
              </q-item-section>

              <q-item-section>
                <q-item-label>[Exercícios] Aula 1 - Análise sintática: Frase </q-item-label>
                <q-item-label caption>A frase se define pelo seu propósito comunicativo, ou seja, pela sua capacidade
                  de...</q-item-label>
              </q-item-section>

            </q-item>
            <div class="q-mx-md q-gutter-x-sm text-left">
              <q-badge rounded color="orange" label="Sintaxe" />
            </div>
          </q-card>
          <q-card class="question">
            <q-item>
              <q-item-section avatar class="items-center">
                <q-avatar color="grey" text-color="white" icon="account_circle" />
                <span>Professor X</span>
              </q-item-section>

              <q-item-section>
                <q-item-label>Aula 1 - Fonema: Fonema e letra</q-item-label>
                <q-item-label caption>1 - Dá-se o nome de fonema ao menor elemento sonoro capaz de estabelecer uma distinção de significado...</q-item-label>
              </q-item-section>

            </q-item>
            <div class="q-mx-md q-gutter-x-sm text-left">
              <q-badge rounded color="blue" label="Fonologia/Fonética" />
            </div>
          </q-card>
        </div>
      </div>
    </div>

  </main>
</template>

<script setup>
</script>

<style>
.question:hover {
  cursor: pointer;
  background-color: rgba(150, 150, 150, 0.3);
}
</style>