<template>
  <main style="background-color: #f5f5dc; height: 100vh;">

    <div id="header" class="flex items-center justify-around">
      <h3>Exercícios</h3>
    </div>
    <div id="content" class="q-pa-md row items-start justify-center q-gutter-md">

      <!-- ciencias da natureza [biologia, química e física] -->
      <q-card class="course">
        <q-card-section class="bg-green text-white">
          <div class="text-h6 text-center">Ciências da Natureza</div>
        </q-card-section>

        <q-separator />

        <q-card-actions align="center">
          <q-btn flat>biologia</q-btn>
          <q-btn flat>química</q-btn>
          <q-btn flat>física</q-btn>
        </q-card-actions>
      </q-card>


      <!-- ciencias humanas [história, geografia, filosofia e sociologia] -->
      <q-card class="course">
        <q-card-section class="bg-orange text-white">
          <div class="text-h6 text-center">Ciências humanas</div>
        </q-card-section>

        <q-separator />

        <q-card-actions align="center">
          <q-btn flat>história</q-btn>
          <q-btn flat>geografia</q-btn>
          <q-btn flat>filosofia</q-btn>
          <q-btn flat>sociologia</q-btn>
        </q-card-actions>
      </q-card>


      <!-- matemática e suas tecnologias [matemática]-->
      <q-card class="course">
        <q-card-section class="bg-blue text-white">
          <div class="text-h6 text-center">Matemática e suas tecnologias</div>
        </q-card-section>

        <q-separator />

        <q-card-actions align="center">
          <q-btn flat>matemática</q-btn>
        </q-card-actions>
      </q-card>

      <!-- linguagens, códigos e suas tecnologias
         [português, literatura, espanhol, inglês, educação física e artes]
        --- -->
      <q-card class="course">
        <q-card-section class="bg-pink text-white">
          <div class="text-h6 text-center">Linguagens, Códigos e suas Tecnologias</div>
        </q-card-section>

        <q-separator />

        <q-card-actions align="center">
          <q-btn flat
            @click="this.$router.push({ name: 'exercises course', params: { course: 'portugues' } })">português</q-btn>
          <q-btn flat>literatura</q-btn>
          <q-btn flat>espanhol</q-btn>
          <q-btn flat>ingles</q-btn>
          <q-btn flat>educação física</q-btn>
          <q-btn flat>artes</q-btn>
        </q-card-actions>
      </q-card>

      
      <!-- redação -->
      <q-card class="course">
        <q-card-section class="bg-red text-white">
          <div class="text-h6 text-center">Redação</div>
        </q-card-section>

        <q-separator />

        <q-card-actions align="center">
          <q-btn flat>redação</q-btn>
        </q-card-actions>
      </q-card>

    </div>

  </main>
</template>

<script setup>
</script>