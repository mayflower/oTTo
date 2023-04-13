<template>
  <div class="w-full md:w-1/2 px-3 pb-6 md:mb-0">
    <Field :name="fieldName" v-slot="{ field }">
      <label
        :for="fieldName"
        class="block uppercase tracking-wide text-neutral-200 text-xs font-bold mb-2"
      >
        {{ labelText }}
      </label>
      <select
        :id="fieldName"
        v-bind="field"
        class="bg-neutral-900 border-b-[1px] border-b-neutral-600 text-neutral-200 text-sm block w-full p-3 focus-visible:outline-none hover:cursor-pointer"
      >
        <option
          v-for="option in options"
          :key="option.key"
          :value="option.key"
        >
          {{ option.name }}
        </option>
      </select>
    </Field>
  </div>
</template>

<script setup lang="ts">
import { Field } from 'vee-validate'

defineProps(['labelText', 'fieldName', 'options'])
</script>
