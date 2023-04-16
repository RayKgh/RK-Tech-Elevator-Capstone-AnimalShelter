<template>
  <div><update-pet-form v-bind:petID="petID" /></div>
</template>

<script>
import UpdatePetForm from "../components/UpdatePetForm.vue";
export default {
  components: { UpdatePetForm },
  props: ["petID"],
};
</script>

<style>
</style>