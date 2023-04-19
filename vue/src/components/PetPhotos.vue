<template>
  <div class="fill">
    <img
      :src="getLastPhoto().source"
      class="image"
      :alt="getLastPhoto().description"
    />
  </div>
</template>

<script>
export default {
  name: "pet-photos",
  props: ["pet"],
  computed: {},
  methods: {
    getLastPhoto() {
      let pictures = this.$store.state.photos.filter(
        (photo) => photo.petID == this.pet.petID
      );
      pictures = pictures[pictures.length - 1];
      return pictures;
    },
  },
};
</script>

<style scoped>
.image {
  display: flex;
  border-radius: 20px;
  align-self: flex-start;
  justify-content: center;
  /* min-width: 95%;
  min-height: 95%;
  max-width: 95%;
  max-height: 95%; */
  height: 310px;
  width: 360px;
  object-fit: cover;
  margin-top: 5px;
}
</style>