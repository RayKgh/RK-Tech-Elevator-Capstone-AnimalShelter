<template>
  <div>
    <h2>Update {{ this.pet.petName }}'s' details</h2>
    <form @submit.prevent="submit()">
      <label for="name">Input sloth's name</label>
      <input type="text" name="name" id="name" v-model="this.pet.petName" />
      <label for="color"></label>
      <input type="text" name="color" id="color" v-model="this.pet.color" />
      <label for="breed"></label>
      <input type="text" name="breed" id="breed" v-model="this.pet.breed" />
      <label for="sex"></label>
      <input type="text" name="sex" id="sex" v-model="this.pet.sex" />
      <label for="vaccinated"></label>
      <input
        type="checkbox"
        name="sex"
        id="sex"
        @change="changeVaccinatedStatus()"
      />
      <label for="petDescription"></label>
      <textarea
        name="petDescription"
        id="petDescription"
        cols="30"
        rows="10"
        v-model="this.pet.petDescription"
      ></textarea>
      <label for="dob"></label>
      <input type="date" name="dob" id="dob" v-model="this.pet.dob" />
      <label for="adoptionDate"></label>
      <input
        type="date"
        name="adoptionDate"
        id="adoptionDate"
        v-model="this.pet.adoptionDate"
      />
      <label for="entryDate"></label>
      <input
        type="date"
        name="entryDate"
        id="entryDate"
        v-model="this.pet.adoptionDate"
      />
      <label for="adoptionStatus"></label>
      <input
        type="text"
        name="adoptionStatus"
        id="adoptionStatus"
        v-model="this.pet.adoptionStatus"
      />

      <button type="submit" @click="update()">update sloth</button>
    </form>
  </div>
</template>

<script>
import PetService from "../services/PetService.js";
export default {
  name: "update-pet-form",
  data() {
    return {
      pet: {
        //create a pet object to use with two way data binding. use pets array from computed
        petName: "",
        color: "",
        breed: "",
        sex: "",
        vaccinated: "",
        petDescription: "",
        dob: "",
        adoptionDate: "",
        adoptionStatus: "",
        entryDate: "",
      },
    };
  },
  computed: {
    pets() {
      //should pull only desired pet from the store. return array of length 1
      return this.$store.state.pets.filter(
        (pet) => pet.petID == this.$route.params.petID
      );
    },
  },
  created() {
    this.fillPet();
  },
  methods: {
    changeVaccinatedStatus() {
      this.pet.vaccinated = !this.pet.vaccinated;
    },
    fillPet() {
      this.pet.petName = this.pets[0].petName;
      this.pet.breed = this.pets[0].breed;
      this.pet.color = this.pets[0].color;
      this.pet.dob = this.pets[0].dob;
      this.pet.adoptionDate = this.pets[0].adoptionDate;
      this.pet.adoptionStatus = this.pets[0].adoptionStatus;
      this.pet.sex = this.pets[0].sex;
      this.pet.petDescription = this.pets[0].petDescription;
      this.pet.vaccinated = this.pets[0].vaccinated;
    },
  },
  methodToForceUpdate() {
    this.$forceUpdate();
  },
  update() {
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

    PetService.updatePet(newPet, this.$route.params.petID)
      .then((response) => {
        if (response.status === 200 || response.status === 201) {
          this.$router.push("/updatepets");
          this.methodToForceUpdate();
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
};
</script>

<style scoped>
</style>