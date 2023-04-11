<template>
  <div class="card">
    <pet-photos v-bind:petID="pet.petID" class="image" />
    <h2 class="name">{{ pet.petName }}</h2>
    <p class="description">{{ pet.petDescription }}</p>
    <router-link :to="{ name: 'home' }" class="button"
      >View More (need to change route)</router-link
    >
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

<style scoped>
.image {
  min-height: 60%;
  min-width: 100%;
  overflow: hidden;
}

.card {
  display: flex;
  width: 400px;
  height: 500px;
  border-radius: 5%;
  flex-direction: column;
  align-items: center;
  margin: 10px;
  background-color: #f2ebe6;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
}

.button {
  background-color: #de854e;
  font-size: 20px;
  color: #f2ebe6;
}
</style>