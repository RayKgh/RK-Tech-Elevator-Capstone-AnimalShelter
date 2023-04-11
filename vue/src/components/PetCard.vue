<template>
  <div class="card">
    <h2 class="pet-name">{{ pet.name }}</h2>
    <img class="pet-image" v-bind:src="'#'" />
  </div>
</template>

<script>
export default {
  name: "pet-card",
  props: ["pet"],
};
</script>

<style>
</style>