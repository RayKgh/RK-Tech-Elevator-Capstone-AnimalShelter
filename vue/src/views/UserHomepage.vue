<template>
  <div class="home">
    <h2>Pet List</h2>

    <pet-table></pet-table>
    <router-link v-bind:to="{ name: 'new-pet' }"
      ><button>Add new pet</button></router-link
    >
  </div>
</template>

<script>
import PetTable from "../components/PetTable.vue";
import PetService from "../services/PetService.js";
export default {
  name: "user-homepage",
  components: {
    PetTable,
  },
  created() {
    PetService.getAllPets()
      .then((pets) => {
        this.$store.commit("SET_ALL_PETS", pets.data);
      })
      .catch((err) => {
        if (err.response) {
          this.errorMsg = `error loading pets. response was ${err.response.statusText}`;
          alert(this.errorMsg);
        } else if (err.request) {
          this.errorMsg = `error loading pets. something went wrong. probably not your fault. well have someone look into it and get back to you.`;
          alert(this.errorMsg);
        } else {
          this.errorMsg =
            "sorry. didn't happen. not sure why. don't bother trying again";
          alert(this.errorMsg);
        }
      });
  },
};
</script>

<style>
h2 {
  font-weight: 900;
  margin: 30px 0 0 0;
  text-align: center;
  font-size: 60px;
  text-transform: uppercase;
   color: #335137
}
</style>