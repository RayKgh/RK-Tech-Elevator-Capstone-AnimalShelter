<template>
  <div class="adopt">
    <pet-catalog />
  </div>
</template>

<script>
import PetCatalog from "../components/PetCatalog.vue";

export default {
  name: "adopt",
  components: { PetCatalog },
};
</script>

<style scoped>
h1 {
  margin: 0;
}

.adopt {
  margin-top: 100px;
}
</style>
