<template>
  <div>
    <h2>Update sloths details</h2>
    <form @submit.prevent="submit()">
      <label for="name">Input sloth's name</label>
      <input type="text" name="name" id="name" v-model="this.pet.petName" />

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
export default {
  name: "update-pet-form",
  data() {
    return {
      pet: {
        // test: "test",
        // petName: this.pets.petName,
        // color: this.pets.color,
        // breed: this.pets.breed,
        // sex: this.pets.sex,
        // vaccinated: this.pets.vaccinated,
        // petDescription: this.pets.petDescription,
        // dob: this.pets.dob,
        // adoptionDate: this.pets.adoptionDate,
        // adoptionStatus: this.pets.adoptionStatus,
        // entryDate: this.pet.entryDate,
      },
    };
  },
  computed: {
    pets() {
      return this.$store.state.pets.filter(
        (pet) => pet.petID == this.$route.params.petID
      );
    },
  },
  methods: {
    changeVaccinatedStatus() {
      this.pet.vaccinated = !this.pet.vaccinated;
    },
  },
};
</script>

<style scoped>
</style>