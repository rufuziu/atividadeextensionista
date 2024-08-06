<template>
  <main class="q-px-lg q-py-xl q-gutter-x-md" style="background-color: #f5f5dc; height: 100vh;">
    <!-- <header align="right" class="q-px-lg q-py-sm q-gutter-x-md">
      <q-btn label="Registre-se"  style="background-color: #98ff98;" @click="this.$router.push({ name: 'register' })" />
      <q-btn label="Já tenho uma conta" flat class="text-black" @click="this.$emit('openRightDrawer')" />
    </header> -->

    <body>
      <h4 class="text-center">Reforço Online</h4>
      
      <div id="metrics">
        <div class="flex justify-center items-center q-gutter-x-md">
          <div id="teachers">
            <div class="circle bg-yellow">
              <span class="cnumber">0</span>
            </div>
            <p class="ctext">Professores</p>
          </div>

          <div id="students">
            <div class="circle bg-blue">
              <span class="cnumber">0</span>
            </div>
            <p class="ctext">Alunos</p>
          </div>

          <div id="lessons">
            <div class="circle bg-green">
              <span class="cnumber">0</span>
            </div>
            <p class="ctext">Lições</p>
          </div>

          <div id="questions">
            <div class="circle bg-red">
              <span class="cnumber">0</span>
            </div>
            <p class="ctext">Dúvidas</p>
          </div>

          <div id="exercises">
            <div class="circle bg-lime">
              <span class="cnumber">0</span>
            </div>
            <p class="ctext">Exercícios</p>
          </div>
        </div>
      </div>

      <div class="q-my-xl q-mx-xl">
        <p class="text-center" style="font-size: 28px;">O Reforço Online é um recurso extra de estudo voltado para ajudar estudantes e professores em suas atividades.</p>
      </div>
    </body>
  </main>
</template>

<script setup>
</script>

<style>
.circle {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 130px;
  height: 120px;
  border-radius: 50%;
}

.cnumber {
  font-size: 56px;
}

.ctext {
  text-align: center;
  font-size: 24px;
}
</style>