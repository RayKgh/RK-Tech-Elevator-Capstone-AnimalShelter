<template>
  <div class="home">
    <h1>edit pets</h1>

    <pet-table></pet-table>
    <router-link v-bind:to="{ name: 'new-pet' }"
      ><button>Add new pet</button></router-link
    >
  </div>
</template>

<script>
import PetTable from "../components/PetTable.vue";
export default {
  name: "user-homepage",
  data() {},
  components: {
    PetTable,
  },
  methods: {},
};
</script>

<style>
</style>