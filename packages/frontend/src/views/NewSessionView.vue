<template>
  <div class="container mx-auto my-6 p-6 bg-neutral-800">
    <div class="font-medium text-xl text-neutral-200">Neue Session hinzufügen</div>
    <hr class="h-px mb-7 mt-2 bg-neutral-600 border-0" />
    <Form
      @submit="onSubmit"
      :validation-schema="schema"
      :initial-values="initialValues"
      class="w-full"
      autocomplete="off"
    >
      <div class="flex flex-wrap -mx-3 mb-2">
        <InputfieldComponent
          label-text="Session-Titel"
          field-name="sessionTitel"
          input-type="text"
        />
        <InputfieldComponent label-text="Speaker" field-name="speaker" input-type="text" />
        <InputfieldComponent
          label-text="Beschreibung"
          field-name="description"
          input-type="textarea"
        />

        <SelectComponent
          label-text="Timeslot auswählen"
          field-name="timeslot"
          :options="timeslotOptions"
        />

        <CheckboxComponent label-text="Diese Session ist eine Keynote" field-name="isKeynote" />

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
import SelectComponent from '@/components/SelectComponent.vue'
import CheckboxComponent from '@/components/CheckboxComponent.vue'
import { Form, configure } from 'vee-validate'
import { object, string, boolean } from 'yup'

configure({
  validateOnBlur: false,
  validateOnChange: true,
  validateOnInput: false,
  validateOnModelUpdate: true
})

const initialValues = {
  sessionTitel: '',
  speaker: '',
  description: '',
  timeslot: '1hslot',
  isKeynote: false
}

const schema = object({
  sessionTitel: string().label('Session-Titel'),
  speaker: string().label('Speaker'),
  description: string().label('Beschreibung'),
  timeslot: string().label('Timeslot'),
  isKeynote: boolean()
})

const timeslotOptions = [
  {
    key: '1hslot',
    name: '1h-Slot'
  },
  {
    key: 'tagesslot',
    name: 'Tagesslot'
  },
  {
    key: 'kleinerslot',
    name: 'kleiner Slot'
  },
  {
    key: 'keineahnung',
    name: 'keine Ahnung'
  }
]

function onSubmit(values: any) {
  alert(JSON.stringify(values, null, 2))
}
</script>
