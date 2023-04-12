<template>
  <div class="pet-container">
    <img
      src="https://cdn-icons-png.flaticon.com/512/271/271220.png"
      alt="left
    arrow"
      id="left"
      class="arrow"
      @click="decrementCount()"
    />
    <pet-card v-for="pet in pets" v-bind:key="pet.petID" v-bind:pet="pet" />
    <img
      src="https://cdn-icons-png.flaticon.com/512/271/271228.png"
      alt="right arrow"
      id="right"
      class="arrow"
      @click="incrementCount()"
    />
  </div>
</template>

<script>
import PetService from "../services/PetService.js";
import PetCard from "./PetCard.vue";

export default {
  data() {
    return {
      lower: 1,
      upper: 3,
    };
  },
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
  methods: {
    carouselPets() {
      return this.pets.filter((pet) => pet.petID <= this.upper);
    },
    decrementCount() {
      this.lower = this.lower - 1;
      this.upper = this.upper - 1;
    },
    incrementCOunt() {
      this.lower = this.lower + 1;
      this.upper = this.upper + 1;
    },
  },
};
</script>

<style scoped>
.pet-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.arrow {
  width: 70px;
  height: 70px;
  align-self: center;
}
</style>