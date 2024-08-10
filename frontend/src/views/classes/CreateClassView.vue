<template>
  <main style="background-color: #f5f5dc; height: 100vh;">

    <div id="header" class="flex items-center justify-around q-pa-md">
      <h3>Criar nova aula</h3>
    </div>
    <div id="content" class="q-px-xl q-gutter-md">
      <div id="preview" style="border: 1px solid black" class="row col-12 bg-white full-width q-pa-md">
        <div class="full-width" v-html="text">
        </div>

      </div>
      <div id="text-editor" class="full-width">
        <q-editor v-model="text" :toolbar="[
          ['left', 'center', 'right', 'justify'],
          ['bold', 'italic', 'strike', 'underline', 'subscript', 'superscript'],
          ['quote', 'unordered', 'ordered', 'outdent', 'indent'],
          ['undo', 'redo']
        ]" />
      </div>
    </div>

  </main>
</template>

<script setup>
import { ref } from 'vue';

let text = ref('')
</script>

<style></style>