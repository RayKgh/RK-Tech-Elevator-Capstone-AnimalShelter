<template>
  <div>
    <div v-for="pet in pets" :key="pet.petID">
      <h3>{{ pet.petName }}</h3>
      <ul>
        <li>{{ pet.breed }}</li>
        <li>{{ pet.color }}</li>
        <li>{{ pet.sex }}</li>
        <li>{{ pet.adoptionStatus }}</li>
        <li>{{ pet.entryDate }}</li>
        <li>{{ pet.petDescription }}</li>
        <li>{{ pet.vaccinated }}</li>
        <li>{{ pet.dob }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
import PetService from "../services/PetService.js";

export default {
  name: "pet-catalog",
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