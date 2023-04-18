<template>
  <div class="home">
    <div class="new-pet">
      <h2>Pet List</h2>
      <router-link v-bind:to="{ name: 'new-pet' }">
        <button class="btn">
          <i class="fa-solid fa-plus fa-large" id="plus"></i>Add new pet
        </button>
      </router-link>
    </div>
    <pet-table></pet-table>
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

<style scoped>
.new-pet {
  display: flex;
  justify-content: space-between;

  width: 1200px;
}

.home {
  display: grid;
  justify-items: center;

  margin: 40px;
}

h2 {
  font-weight: 900;
 margin-left: 20px;
  text-align: center; 
  font-size: 60px;
  text-transform: uppercase;
  color: #335137;
}

.btn {
  border: dashed black;
  border-radius: 50px;
  border: 0;
  box-shadow: rgba(0, 0, 0, 0.2);

  background-color: #de854e;
  color: white;
  padding: 8px 25px;
  margin-top: 20px;
  font-weight: 800;
  font-size: 20px;
  text-transform: uppercase;
  margin: 20px;
}

#plus {
  margin: 5px;
}
</style>
