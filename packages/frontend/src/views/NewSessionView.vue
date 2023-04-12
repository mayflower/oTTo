<template>
  <div class="container mx-auto my-6 p-6 bg-neutral-800">
    <Form @submit="onSubmit" :validation-schema="schema" class="w-full" autocomplete="off">
      <div class="flex flex-wrap -mx-3 mb-6">
        <InputfieldComponent label="Session-Name" field-name="sessionName" input-type="text" />
        <InputfieldComponent label="Author" field-name="author" input-type="text" />

        <div class="w-full px-3 mb-6">
          <ButtonComponent text="Senden" />
        </div>
      </div>
    </Form>
  </div>
</template>

<script setup lang="ts">
import InputfieldComponent from '@/components/InputfieldComponent.vue';
import ButtonComponent from '@/components/ButtonComponent.vue';
import { Form, configure } from 'vee-validate'
import { object, string } from 'yup'

configure({
  validateOnBlur: false,
  validateOnChange: true,
  validateOnInput: false,
  validateOnModelUpdate: true
})

const schema = object({
  sessionName: string().required().label('Session-Name'),
  author: string().required().label('Author')
})

function onSubmit(values: any) {
  alert(JSON.stringify(values, null, 2))
}
</script>
