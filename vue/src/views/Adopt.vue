<template>
  <div>
    <h1>Adopt</h1>
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
</style>