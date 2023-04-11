<template>
  <div class="card">
    <h3>{{ pet.petName }}</h3>
    <pet-photos v-bind:petID="pet.petID" />
    <p>{{ pet.petDescription }}</p>
  </div>
</template>

<script>
import PetPhotos from "./PetPhotos.vue";
export default {
  components: { PetPhotos },
  name: "pet-card",
  props: ["pet"],
};
</script>

<style>
</style>