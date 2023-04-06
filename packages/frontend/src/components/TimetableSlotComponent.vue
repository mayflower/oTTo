<template>
  <div
    class="w-full mt-0.5 absolute"
    :style="{
      height: duration * 3 - 0.2 + 'rem',
      top: sessionStart * 3 + 'rem'
    }"
  >
    <div
      v-if="isKeynote"
      class="absolute overflow-hidden bg-neutral-900 opacity-30"
      :style="calculateKeynoteSpaceLeft()"
    >
      <div class="h-full overflow-hidden flex justify-around">
        <fa-icon v-for="ind in index * 2" :key="ind" class="h-full" icon="chevron-right"></fa-icon>
      </div>
    </div>
    <div
      class="p-2 rounded-md h-full"
      :style="{
        backgroundColor: room.color
      }"
    >
      <div class="flex flex-col justify-center overflow-hidden">
        <div>
          <span class="text-sm font-bold line-clamp-2">
            {{ isKeynote ? 'KEYNOTE: ' : '' }}
            {{ title }}
          </span>
          <div class="flex flex-col text-xs mt-1">
            <span>
              <fa-icon icon="user" class="text-black opacity-40 w-5" />
              {{ host }}
            </span>
            <span>
              <fa-icon icon="clock" class="text-black opacity-40 w-5" />
              {{ start }} - {{ end }}
            </span>
            <span>
              <fa-icon icon="location-dot" class="text-black opacity-40 w-5" />
              {{ room.name }}
            </span>
          </div>
        </div>
      </div>
    </div>
    <div
      v-if="isKeynote"
      class="absolute top-0 overflow-hidden bg-neutral-900 opacity-30"
      :style="calculateKeynoteSpaceRight()"
    >
      <div class="h-full overflow-hidden flex justify-around">
        <fa-icon v-for="ind in (roomsCount - index - 1) * 2" :key="ind" class="h-full" icon="chevron-left"></fa-icon>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
const props = defineProps([
  'title',
  'host',
  'room',
  'start',
  'end',
  'duration',
  'sessionStart',
  'isKeynote',
  'index',
  'roomsCount'
])

function calculateKeynoteSpaceLeft() {
  const baseGap = '8px'
  const gapSpaceCalc = `${baseGap} * 2 * ${props.index} + ${baseGap}`

  return {
    transform: `translateX(calc(-100% + (${gapSpaceCalc})))`,
    width: `calc(100% * ${props.index} + (${gapSpaceCalc}))`,
    margin: `0 calc(-${baseGap}  * (${props.index} * 2 + 1))`,
    height: '100%'
  }
}

function calculateKeynoteSpaceRight() {
  const baseGap = '8px'
  const gapSpaceCalc = `${props.roomsCount} - ${props.index} - 1`

  return {
    transform: `translateX(calc(100% / (${gapSpaceCalc}) - (${baseGap} * 2)))`,
    width: `calc(100% * (${gapSpaceCalc}) + (${baseGap} * (${props.roomsCount} - (${props.index} + 1)) * 2))`,
    height: '100%'
  }
}
</script>
