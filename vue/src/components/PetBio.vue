<template>
  <div>
    <h2>{{ pets[0].petName }}</h2>
    <div class="photo-container">
      <img v-for="photo in photos" :key="photo.photoID" src="photo.source" />
    </div>
    <ul>
      <li>{{ pets[0].dob }}</li>
      <li>{{ pets[0].sex }}</li>
      <li>{{ pets[0].breed }}</li>
      <li>{{ pets[0].color }}</li>
      <li>{{ pets[0].vaccinated }}</li>
    </ul>
    <p>{{ pets[0].description }}</p>
  </div>
</template>

<script>
import PetService from "../services/PetService.js";
import PetPhotoService from "../services/PetPhotoService.js";

export default {
  name: "pet-bio",
  computed: {
    pets() {
      let pets = this.$store.state.pets.filter(
        (pet) => pet.petID == this.$route.params.id
      );
      return pets;
    },
    photos() {
      let photos = this.$store.state.photos.filter(
        (photo) => photo.petID == this.$route.params.id
      );
      return photos;
    },
  },
  created() {
    PetService.getAllPets().then((pets) =>
      this.$store.commit("SET_ALL_PETS", pets.data)
    );
  },
  beforeCreate() {
    PetPhotoService.getAllPetPhotos().then((photos) =>
      this.$store.commit("SET_PHOTOS", photos.data)
    );
  },
};
</script>

<style scoped>
</style>