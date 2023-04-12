<template>
  <div class="fill">
    <img
      :src="getFirstPhoto().source"
      class="image"
      :alt="getFirstPhoto().description"
    />
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
    getFirstPhoto() {
      let pictures = this.photosById();
      pictures = pictures[0];
      return pictures;
    },
  },
};
</script>

<style scoped>
.image {
  display: flex;
  border-radius: 40%;
  align-self: flex-start;
  justify-content: center;
  min-width: 95%;
  min-height: 95%;
  max-width: 95%;
  margin-top: 5px;
}
</style>