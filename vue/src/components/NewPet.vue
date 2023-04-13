<template>
  <div>
    <h2>Add new pet details</h2>
    <form @submit.prevent="submit">
      <label for="name">Input sloth's name</label>
      <input type="text" name="name" id="name" v-model="pet.petName" />

      <label for="color">input sloth's color</label>
      <input type="text" name="color" id="color" v-model="pet.color" />

      <label for="breed">input sloth's breed</label>
      <input type="text" name="breed" id="breed" v-model="pet.breed" />

      <label for="sex">input sloth's sex</label>
      <input type="text" name="sex" id="sex" v-model="pet.sex" />

      <label for="is-vaccinated">is vaccinated</label>
      <input
        type="checkbox"
        name="vaccinated"
        id="vaccinated"
        @change="changeVaccinatedStatus()"
      />

      <label for="description">describe the sloth</label>
      <textarea
        type="text"
        name="desciption"
        id="description"
        v-model="pet.petDescription"
      />
      <label for="date">add sloth's birthday</label>
      <input type="date" name="dob" id="dob" v-model="pet.dob" />

      <button type="submit">submit new sloth</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "new-pet",
  data() {
    return {
      pet: {
        petName: "",
        color: "",
        breed: "",
        sex: "",
        vaccinated: false,
        petDescription: "",
        dob: "",
      },
    };
  },
  methods: {
    changeVaccinatedStatus() {
      this.pet.vaccinated = !this.pet.vaccinated;
    },
  },
  submit() {
    axios
      .post("/pets/add", this.pet)
      .then((response) => {
        if (response.status == 201) {
          this.$router.push({ name: "home" });
        }
      })
      .catch((error) => {
        const response = error.response;

        if (response.status === 400) {
          this.submitError = true;
        }
      });
  },
};
</script>

<style scoped>
</style>