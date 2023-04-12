<template>
  <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
    <label class="block uppercase tracking-wide text-neutral-200 text-xs font-bold mb-2">
      {{ label }}
    </label>
    <Field :name="fieldName" v-slot="{ field, errors }">
      <input
        v-bind="field"
        :type="inputType"
        class="appearance-none block w-full bg-neutral-900 text-neutral-200 border-t-neutral-900 border-t-[1px] border-b-neutral-600 border-b-[1px] py-3 px-4 mb-1 leading-tight focus:border-b-2 focus:border-t-0 focus:outline-none"
        :class="{ 'border-b-red-700': !!errors.length }"
      />
    </Field>
    <ErrorMessage :name="fieldName" class="text-red-500 text-xs" />
  </div>
</template>

<script setup lang="ts">
import { Field, ErrorMessage } from 'vee-validate'

defineProps(['label', 'fieldName', 'inputType'])

</script>