<template>
  <div class="container mx-auto my-6 p-6 bg-neutral-800">
    <div class="font-medium text-xl text-neutral-200">Neue Session hinzufügen</div>
    <hr class="h-px mb-7 mt-2 bg-neutral-600 border-0" />
    <Form @submit="onSubmit" :validation-schema="schema" class="w-full" autocomplete="off">
      <div class="flex flex-wrap -mx-3 mb-2">
        <InputfieldComponent label="Session-Titel" field-name="sessionTitel" input-type="text" />
        <InputfieldComponent label="Speaker" field-name="speaker" input-type="text" />
        <InputfieldComponent label="Beschreibung" field-name="description" input-type="textarea" />
        <InputfieldComponent label="Timeslot" field-name="timeslot" input-type="text" />

        <CheckboxComponent label="Diese Session ist eine Keynote" field-name="isKeynote" />

        <div class="w-full px-3 mt-3">
          <ButtonComponent text="Senden" />
        </div>
      </div>
    </Form>
  </div>
</template>

<script setup lang="ts">
import InputfieldComponent from '@/components/InputfieldComponent.vue'
import ButtonComponent from '@/components/ButtonComponent.vue'
import CheckboxComponent from '@/components/CheckboxComponent.vue'
import { Form, configure } from 'vee-validate'
import { object, string, boolean } from 'yup'

configure({
  validateOnBlur: false,
  validateOnChange: true,
  validateOnInput: false,
  validateOnModelUpdate: true
})

const schema = object({
  sessionTitel: string().label('Session-Titel').required(),
  speaker: string().label('Speaker').required(),
  description: string().label('Beschreibung').required(),
  timeslot: string().label('Timeslot').required(),
  isKeynote: boolean() // defaultvalue fehlt noch
})

function onSubmit(values: any) {
  alert(JSON.stringify(values, null, 2))
}
</script>
