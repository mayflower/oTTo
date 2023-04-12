<template>
  <div class="w-full md:w-1/2 px-3 pb-4 md:mt-[23px]">
    <div class="flex items-center pl-4 border border-neutral-600 hover:cursor-pointer">
      <Field
        v-slot="{ field, value }"
        :name="fieldName"
        type="checkbox"
        :value="true"
        :unchecked-value="false"
      >
        <label
          :for="fieldName"
          class="w-full py-3 ml-2 text-sm text-neutral-200 hover:cursor-pointer"
        >
          <input
            :id="fieldName"
            type="checkbox"
            v-bind="field"
            :value="true"
            :checked="false"
            class="w-4 h-4 bg-neutral-100 border-gray-300 rounded accent-orange-600 hover:cursor-pointer"
          />
          {{ label }} {{ field }} {{ value }}
        </label>
      </Field>
    </div>
  </div>
</template>

<script setup lang="ts">
import { Field } from 'vee-validate'

defineProps(['label', 'fieldName'])
</script>
