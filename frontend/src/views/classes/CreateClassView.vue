<template>
  <main style="background-color: #f5f5dc; height: 70vh;">

    <div id="header" class="flex items-center justify-center q-pa-xs">
      <h3>Criar nova aula</h3>
    </div>
    <div id="content" class="row full-height">
      <div id="preview" style="border: 1px solid black" class="col-6 bg-white">
        <div class="full-width" v-html="text">
        </div>

      </div>
      <div id="text-editor" class="col-6 bg-red full-height">
        <q-editor v-model="text" class="  " :toolbar="[
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