<template>
    <q-dialog v-model="status" @update:model-value="() => this.$emit('closeDialog')">
        <q-card style="width: 300px">
            <q-card-section>
                <div class="text-h6">Small</div>
            </q-card-section>

            <q-card-section class="q-pt-none">
                Click/Tap on the backdrop.
            </q-card-section>

            <q-card-actions align="right" class="bg-white text-teal">
                <q-btn flat label="OK" v-close-popup @click="this.$emit('closeDialog')" />
            </q-card-actions>
        </q-card>
    </q-dialog>
</template>
<script setup>
import { computed } from 'vue';


const props = defineProps(['dialogStatus'])

const status = computed(() => props.dialogStatus)

</script>
<style scoped></style>
