<template>
    <main>
        <div id="header" class="flex items-center justify-around">
            <h3>Feedback de {{ feedback.name.value }}</h3>
        </div>
        <div id="content" class="flex justify-center q-mx-lg q-gutter-x-md">
            <div id="user-feedback-filter" style="width:20%">
                <q-card id="filter-card" class="full-width">
                    <q-card-section class="option" @click="changeFeedback(0)">
                        <span>Seus comentários</span>
                    </q-card-section>
                    <q-separator />
                    <q-card-section class="option" @click="changeFeedback(1)">
                        <span>Suas dúvidas</span>
                    </q-card-section>
                    <q-separator />
                    <q-card-section class="option" @click="changeFeedback(2)">
                        <span>Lições vistas</span>
                    </q-card-section>
                    <q-separator />
                    <q-card-section class="option" @click="changeFeedback(3)">
                        <span>Exercícios vistos</span>
                    </q-card-section>
                </q-card>
            </div>
            <div id="user-feedback" class="row" style="width: 70%;">
                <div id="col" v-for="feed in feedback.feeds" class="col-12 q-gutter-y-md">
                    <q-card class="feed">
                        <q-item>
                            <q-item-section avatar class="items-center">
                                <q-avatar color="red" text-color="white" icon="account_circle" />
                                <span>{{ feed.writer }}</span>
                            </q-item-section>

                            <q-item-section>
                                <q-item-label>{{ feed.title }}</q-item-label>
                                <q-item-label caption>{{ feed.text }} </q-item-label>
                            </q-item-section>

                        </q-item>
                        <div class="q-mx-md q-gutter-x-sm text-left">
                            <q-badge rounded color="green" :label="feed.category" />
                        </div>
                    </q-card>
                </div>
            </div>
        </div>

    </main>
</template>
  
<script setup>
import { ref } from 'vue';

let feedComments = [
    {
        writer: "Teste Usuário 1",
        title: "Teste Comentário 1",
        text: "Teste comentários texto 1",
        category: "Teste categoria 1"
    },
    {
        writer: "Teste Usuário 2",
        title: "Teste Comentário 2",
        text: "Teste comentários texto 2",
        category: "Teste categoria 2"
    },
]
let feedQuestions = [
    {
        writer: "Teste Usuário 1",
        title: "Teste Dúvida 1",
        text: "Teste dúvida texto 1",
        category: "Teste categoria 1"
    }
]
let feedLessons = [
    {
        writer: "Teste Usuário 1",
        title: "Teste Lição 1",
        text: "Teste lição texto 1",
        category: "Teste categoria 1"
    }
]
let feedExercises = [
    {
        writer: "Teste Usuário 1",
        title: "Teste Exercício 1",
        text: "Teste exercício texto 1",
        category: "Teste categoria 1"
    }
]

let feedback = {
    name: ref('Comentários'),
    feeds: feedComments
}

let changeFeedback = (feedId) => {
    switch (feedId) {
        case 0:
            feedback.name.value = "Comentários"
            feedback.feeds = feedComments
            break;
        case 1:
            feedback.name.value = "Dúvidas"
            feedback.feeds = feedQuestions
            break;
        case 2:
            feedback.name.value = "Lições"
            feedback.feeds = feedLessons
            break;
        case 3:
            feedback.name.value = "Exercícios"
            feedback.feeds = feedExercises
            break;
    }

}
</script>
  
<style>
.option:hover,
.feed:hover {
    cursor: pointer;
    background-color: rgba(150, 150, 150, 0.3);
}
</style>