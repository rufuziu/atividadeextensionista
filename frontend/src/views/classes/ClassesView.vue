<script setup>
import { onMounted, ref } from "vue"
import EducationLevelService from "../../services/knowledge-area-and-subjects/EducationLevelService";
import KnowledgeAreaService from "../../services/knowledge-area-and-subjects/KnowledgeAreaService";
import SubjectService from "../../services/knowledge-area-and-subjects/SubjectService";

let educationLevels = ref([])
let educationLevelId = ref('')
let knowledgeAreas = ref([])
let knowledgeAreaId = ref('')
let subjects = ref([])
let subjectId = ref('')
let dialogStatus = ref(false)
let dialogVar = ref('')


const readKnowledgeAreaByEducationLevelId = async (id) => {
  await KnowledgeAreaService.readByEducationLevelId(id)
    .then(response => {
      switch (response.status) {
        case 200:
          console.log(response)
          knowledgeAreas.value = response.data;
          break;
      }
    })
    .catch(error => {
      console.error(error)
    })
}

const readSubjectsByKnowledgeAreaId = async (id) => {
  await SubjectService.readByKnowledgeAreaId(id)
    .then(response => {
      switch (response.status) {
        case 200:
          console.log(response)
          subjects.value = response.data;
          break;
      }
    })
    .catch(error => {
      console.error(error)
    })
}

onMounted(async () => {
  await EducationLevelService.readAll()
    .then(response => {
      switch (response.status) {
        case 200:
          console.log(response)
          educationLevels.value = response.data;
          break;
      }
    })
    .catch(error => {
      console.error(error)
    })
})

</script>
<template>
  <main style="background-color: #f5f5dc; margin:0; padding:0; box-sizing: border-box;" class="window-height">
    <div id="header" class="flex items-center justify-around">
      <h4>Aulas</h4>
    </div>
    <div id="content" class="row justify-center items-start items-start q-gutter-x-lg">
      <div id="filters" class="row col-3 items-start">
        <q-card id="filter-card" class="full-width">
          <q-card-section>
            <p>Escolariedade</p>
            <q-select filled dense :options="educationLevels" option-label="name" option-value="id" emit-value
              map-options v-model="educationLevelId"
              @update:model-value="readKnowledgeAreaByEducationLevelId(educationLevelId)"
              label="Selecione uma escolariedade..." />
          </q-card-section>
          <q-separator inset />
          <q-card-section>
            <p>Área de conhecimento</p>
            <q-select filled dense :options="knowledgeAreas" option-label="name" option-value="id" emit-value
              map-options v-model="knowledgeAreaId" @update:model-value="readSubjectsByKnowledgeAreaId(knowledgeAreaId)"
              label="Selecione uma área de conhecimento..." />
          </q-card-section>
          <q-separator inset />
          <q-card-section>
            <p>Matéria</p>
            <q-select filled dense :options="subjects" option-label="content" option-value="id" emit-value map-options
              v-model="subjectId" label="Selecione uma matéria...">
              <template v-slot:option="scope">
                <q-item v-bind="scope.itemProps">
                  <q-item-section>
                    <q-item-label>{{ scope.opt.name }} - {{ scope.opt.content }}</q-item-label>
                  </q-item-section>
                </q-item>
              </template>
            </q-select>
          </q-card-section>
          <q-card-actions class="justify-end">
            <q-btn style="background-color:#003366; color:white;">Filtrar</q-btn>
          </q-card-actions>
        </q-card>
      </div>
      <div id="questions" class="col-8 row">
        <div id="col" class="col-12 q-gutter-y-md">
          <q-card class="question" @click="() => {
            dialogStatus = true
            dialogVar = 'openQuestionsOrLessons'
          }">
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
                <q-item-label caption>Bom noite, preciso de ajuda pra como desenvolver uma redação
                  sobre...</q-item-label>
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

<style>
.question:hover {
  cursor: pointer;
  background-color: rgba(150, 150, 150, 0.3);
}
</style>