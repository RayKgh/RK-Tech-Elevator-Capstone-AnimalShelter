<template>
  <div>
    <div v-for="photo in photosById()" :key="photo.photoID">
      <p>{{ photo.description }}</p>
    </div>
  </div>
</template>

<script>
import PetPhotoService from "../services/PetPhotoService.js";

export default {
  name: "pet-photos",
  props: ["petID"],
  computed: {
    photos() {
      return this.$store.state.photos;
    },
  },
  created() {
    PetPhotoService.getAllPetPhotos().then((photos) => {
      this.$store.commit("SET_PHOTOS", photos.data);
    });
  },
  methods: {
    photosById() {
      return this.photos.filter((photo) => photo.petID == this.petID);
    },
  },
};
</script>

<style>
</style>