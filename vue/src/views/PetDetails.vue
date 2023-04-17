<template>
  <div>
    <pet-bio v-bind:id="id" />
  </div>
</template>

<script>
import PetBio from "../components/PetBio.vue";
export default {
  components: { PetBio },
  props: ["id"],
  computed: {
    test() {
      console.log(this.id);
      return true;
    },
  },
};
</script>

<style scoped></style>
