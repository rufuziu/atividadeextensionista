<template>
  <main>
    <div id="header" class="flex items-center justify-around">
      <h3>Todas as perguntas</h3>
      <q-btn color="primary">Faça uma pergunta</q-btn>
    </div>
    <div id="content" class="flex justify-center q-mx-lg q-gutter-x-md">
      <div id="filters" style="width:20%">
        <q-card id="filter-card" class="full-width">
          <q-card-section>
            <h4>Área de conhecimento</h4>
            <q-checkbox v-model="teal" label="Linguagens, Códigos e suas Tecnologias" color="pink" />
            <q-checkbox v-model="orange" label="Ciências Humanas" color="orange" />
            <q-checkbox v-model="red" label="Ciências da Natureza" color="green" />
            <q-checkbox v-model="cyan" label="Matemática e suas Tecnologias" color="blue" />
            <q-checkbox v-model="cyan" label="Redação" color="red" />
          </q-card-section>
          <q-separator inset />
          <q-card-section>
            <h4>Matéria</h4>
            <q-checkbox v-model="teal" label="Português" color="pink" />
            <q-checkbox v-model="teal" label="Literatura" color="pink" />
            <q-checkbox v-model="teal" label="Espanhol" color="pink" />
            <q-checkbox v-model="teal" label="Inglês" color="pink" />
            <q-checkbox v-model="teal" label="Educação Física" color="pink" />
            <q-checkbox v-model="teal" label="Artes" color="pink" />
            <q-checkbox v-model="orange" label="História" color="orange" />
            <q-checkbox v-model="orange" label="Geografia" color="orange" />
            <q-checkbox v-model="orange" label="Filosofia" color="orange" />
            <q-checkbox v-model="orange" label="Sociologia" color="orange" />
            <q-checkbox v-model="red" label="Biologia" color="green" />
            <q-checkbox v-model="red" label="Química" color="green" />
            <q-checkbox v-model="red" label="Física" color="green" />
            <q-checkbox v-model="cyan" label="Matemática" color="blue" />
            <q-checkbox v-model="cyan" label="Redação" color="red" />
          </q-card-section>
        </q-card>
      </div>
      <div id="questions" class="row" style="width: 70%;">
        <div id="col" class="col-12 q-gutter-y-md">
          <q-card class="question">
            <q-item>
              <q-item-section avatar class="items-center">
                <q-avatar color="blue" text-color="white" icon="account_circle" />
                <span>Estudande 1</span>
              </q-item-section>

              <q-item-section>
                <q-item-label>Estou com dúvida sobre a lição de História do Brasil</q-item-label>
                <q-item-label caption>Boa tarde, tenho uma dúvida sobre a lição História do Brasil no
                  período...</q-item-label>
              </q-item-section>

            </q-item>
            <div class="q-mx-md q-gutter-x-sm text-left">
              <q-badge rounded color="orange" label="Ciências Humanas" />
              <q-badge rounded color="orange" label="História" />
            </div>
          </q-card>
          <q-card class="question">
            <q-item>
              <q-item-section avatar class="items-center">
                <q-avatar color="yellow" text-color="black" icon="account_circle" />
                <span>Estudande 3</span>
              </q-item-section>

              <q-item-section>
                <q-item-label>Dúvida sobre funções polinomiais</q-item-label>
                <q-item-label caption>Dado a função f(x) = an . xn + an – 1 . xn – 1 + ...+a2 . x2 + a1 . x +
                  a0...</q-item-label>
              </q-item-section>

            </q-item>
            <div class="q-mx-md q-gutter-x-sm text-left">
              <q-badge rounded color="blue" label="Matemática e suas Tecnologias" />
              <q-badge rounded color="blue" label="Matemática" />
            </div>
          </q-card>
          <q-card class="question">
            <q-item>
              <q-item-section avatar class="items-center">
                <q-avatar color="green" text-color="white" icon="account_circle" />
                <span>Estudande 7</span>
              </q-item-section>

              <q-item-section>
                <q-item-label>[AJUDA] Preciso de ajuda em um exercício de redação</q-item-label>
                <q-item-label caption>Bom noite, preciso de ajuda pra como desenvolver uma redação sobre...</q-item-label>
              </q-item-section>

            </q-item>
            <div class="q-mx-md q-gutter-x-sm text-left">
              <q-badge rounded color="red" label="Redação" />
              <q-badge rounded color="red" label="Redação" />
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