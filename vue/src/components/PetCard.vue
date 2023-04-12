<template>
  <div class="card">
    <pet-photos v-bind:petID="pet.petID" class="image" />
    <h2 class="name">{{ pet.petName }}</h2>
    <p class="description">{{ pet.petDescription }}</p>
    <router-link :to="{ name: 'home' }" class="button"
      >More {{ pet.petName }}</router-link
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
  min-height: 50%;
  max-height: 50%;
  min-width: 100%;
  overflow: hidden;
}

.card {
  display: flex;
  width: 40vh;
  height: 70vh;
  border-radius: 5%;
  flex-direction: column;
  align-items: center;
  margin: 10px;
  background-color: #f2ebe6;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  overflow: hidden;
}

.description {
  align-self: flex-start;
  text-align: left;
  margin: 5px;
  font-size: 15px;
}

.button {
  display: flex;
  background-color: #de854e;
  font-size: 20px;
  color: #f2ebe6;
  align-items: flex-end;
  margin: 0 3px 3px 3px;
  margin-top: auto;
  margin-left: auto;
  border-radius: 25%;
  min-width: 40%;
  max-width: 50%;
  justify-content: center;
  align-items: center;
  min-height: 10%;
}
</style>