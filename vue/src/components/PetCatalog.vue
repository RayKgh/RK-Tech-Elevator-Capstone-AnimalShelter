<template>
  <div class="pet-container">
    <pet-card v-for="pet in pets" v-bind:key="pet.petID" v-bind:pet="pet" />
  </div>
</template>

<script>
import PetService from "../services/PetService.js";
import PetCard from "./PetCard.vue";

export default {
  name: "pet-catalog",
  components: {
    PetCard,
  },
  computed: {
    pets() {
      return this.$store.state.pets;
    },
  },
  created() {
    PetService.getAllPets().then((pets) => {
      this.$store.commit("SET_ALL_PETS", pets.data);
    });
  },
};
</script>

<style scoped>
</style>