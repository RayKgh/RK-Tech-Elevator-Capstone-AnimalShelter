<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <br>
    <br>
    <pet-table></pet-table>
  </div>
</template>

<script>
import PetTable from "../components/PetTable.vue"
export default {
  name: "home",
  data() {

  },
  components: {
    PetTable
  },
  methods: {
    
  }
};
</script>

<style> 


</style>
