<template>
  <div>
    <h2>Add new pet details</h2>
    <form>
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

      <label for="photoUrl"> add sloth photo </label>
      <input type="text" name="photoUrl" id="photoUrl" v-model="pet.source" />

      <textarea
        type="text"
        name="description"
        id="description"
        v-model="pet.description"
      />
      <label> add photo desciption </label>

      <button type="submit">submit new sloth</button>
    </form>
  </div>
</template>

<script>
import PetService from "../services/PetService";
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
        source: "",
        photoDescription: "",
      },
    };
  },
  methods: {
    changeVaccinatedStatus() {
      this.pet.vaccinated = !this.pet.vaccinated;
    },
    submit() {
      const newPet = {
        petName: this.pet.petName,
        color: this.pet.color,
        breed: this.pet.breed,
        sex: this.pet.sex,
        vaccinated: this.pet.vaccinated,
        petDescription: this.pet.petDescription,
        dob: this.pet.dob,
        source: this.pet.source,
        photoDescription: this.pet.photoDescription,
      };

      PetService.addNewPet(newPet)
        .then((response) => {
          if (response.status === 200 || response.status === 201) {
            this.$router.push("/updatepets");
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error, "adding");
        });
    },
    handleErrorResponse(error, verb) {
      if (error.response) {
        this.errorMsg =
          "Error " +
          verb +
          " pet. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.errorMsg = "Error " + verb + " pet. Server could not be reached.";
      } else {
        this.errorMsg = "Error " + verb + " pet. Request could not be created.";
      }
    },
  },
};
</script>

<style scoped>
</style>