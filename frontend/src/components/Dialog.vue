<template>
    <q-dialog v-model="status" @update:model-value="() => this.$emit('closeDialog')">
        <q-card class="full-width">
            <q-card-section v-if="dialogVar == 'newQuestion'">
                <div class="row q-gutter-y-md ">
                    <q-input outlined class="col-12" label="Título" />
                    <q-select class="col-12" outlined v-model="model" :options="options" label="Área de Conhecimento" />
                    <q-select class="col-12" outlined v-model="model" :options="options" label="Matéria" />
                    <q-editor class="col-12" v-model="editor" />
                </div>
                <q-card-actions align="right" class="bg-white text-teal">
                    <q-btn flat class="bg-primary text-white" label="Tirar dúvida" v-close-popup
                        @click="this.$emit('closeDialog')" />
                </q-card-actions>
            </q-card-section>

            <q-card-section v-else-if="dialogVar == 'openQuestionsOrLessons'">
                <q-dialog v-model="respond" persistent transition-show="scale" transition-hide="scale">
                    <q-card class="text-black full-width">
                        <q-card-section>
                            <div class="text-h6">Escreva sua resposta</div>
                        </q-card-section>

                        <q-card-section class="q-pa-md">
                            <q-editor class="col-12" v-model="editor" />
                        </q-card-section>

                        <q-card-actions align="right">
                            <q-btn flat label="Enviar" class="bg-primary" color="white" v-close-popup />
                        </q-card-actions>
                    </q-card>
                </q-dialog>
                <div class="row q-gutter-y-md ">
                    <q-card class="col-12 q-pa-md">
                        <q-item-section>
                            <span class="title">Estou com dúvida sobre a lição de História do Brasil</span>
                            <div class="category">
                                <q-badge rounded color="orange" label="Ciências Humanas" />
                                <q-badge rounded color="orange" label="História" />
                            </div>
                        </q-item-section>
                        <q-separator />
                        <q-item-section class="q-ma-md">
                            <div class="content">
                                Boa tarde, tenho uma dúvida sobre a lição História do Brasil no
                                período colonial.
                            </div>
                            <div class="flex justify-between items-center">
                                <span class="date">12/11/2023 14:33</span>
                                <div class="user">
                                    <q-avatar color="blue" size="md" text-color="white" icon="account_circle" />
                                    <span>Estudande 1</span>
                                </div>
                            </div>
                        </q-item-section>

                        <q-separator />
                        <!-- comentários -->

                        <q-item-section class="q-ma-md">
                            <div class="content">
                                Boa noite, seja mais específico sobre sua dúvida querido aluno.
                            </div>
                            <div class="flex justify-between items-center">
                                <span class="date">12/11/2023 18:55</span>
                                <div class="user">
                                    <q-avatar color="green" size="md" text-color="white" icon="account_circle" />
                                    <span>Professor B</span>
                                </div>
                            </div>
                        </q-item-section>

                        <q-separator />
                        <q-item-section class="q-ma-md">
                            <div class="content">
                                Boa noite querido Estudante 1, talvez você queira acessar a lição sobre <a href="">Aula 1 -
                                    Brasil Colonial</a>
                            </div>
                            <div class="flex justify-between items-center">
                                <span class="date">12/11/2023 19:17</span>
                                <div class="user">
                                    <q-avatar color="pink" size="md" text-color="white" icon="account_circle" />
                                    <span>Professor F</span>
                                </div>
                            </div>
                        </q-item-section>
                        <q-separator />

                        <q-item-section class="q-ma-md">
                            <div class="content">
                                Boa noite talvez fazer mais exercícios sobre o Brasil Colônia ajude. Até mais!
                            </div>
                            <div class="flex justify-between items-center">
                                <span class="date">13/11/2023 11:15</span>
                                <div class="user">
                                    <q-avatar color="black" size="md" text-color="white" icon="account_circle" />
                                    <span>Estudande 5</span>
                                </div>
                            </div>
                        </q-item-section>
                        <q-separator />

                        <q-item-section class="q-ma-md">
                            <div class="content">
                                Boa tarde, tenho uma dúvida sobre a lição História do Brasil no
                                período colonial.
                            </div>
                            <div class="flex justify-between items-center">
                                <span class="date">12/11/2023 14:33</span>
                                <div class="user">
                                    <q-avatar color="blue" size="md" text-color="white" icon="account_circle" />
                                    <span>Estudande 1</span>
                                </div>
                            </div>
                        </q-item-section>

                    </q-card>
                </div>
                <q-card-actions align="right" class="bg-white text-teal">
                    <q-btn flat class="bg-primary text-white" label="Responder" @click="respond = true" />
                </q-card-actions>
            </q-card-section>

        </q-card>
    </q-dialog>
</template>
<script setup>
import { computed, ref } from 'vue';


const props = defineProps(['dialogStatus', 'dialogVar'])

const status = computed(() => props.dialogStatus)

let respond = ref(false)

</script>
<style scoped>
.title {
    font-size: 22px;
}
</style>
