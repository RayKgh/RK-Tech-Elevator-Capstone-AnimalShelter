<template>
  <div class="pet-container">
    <h2 v-if="petsLen === 0">
      There are no pets available for adoption at this time.
    </h2>
    <div v-else class="pet-container">
      <img
        src="https://cdn-icons-png.flaticon.com/512/271/271220.png"
        alt="left
    arrow"
        id="left"
        class="arrow"
        @click="decrementStart()"
      />
      <pet-card v-model="pets[start]" v-bind:pet="pets[start]" />
      <pet-card v-model="pets[this.middle]" v-bind:pet="pets[this.middle]" />
      <pet-card v-model="pets[end]" v-bind:pet="pets[end]" />
      <img
        src="https://cdn-icons-png.flaticon.com/512/271/271228.png"
        alt="right arrow"
        id="right"
        class="arrow"
        @click="incrementStart()"
      />
    </div>
  </div>
</template>

<script>
import PetService from "../services/PetService.js";
import PetCard from "./PetCard.vue";

export default {
  data() {
    return {
      start: 0,
      offset: 2,
      petsInArray: true,
      errMsg: "",
    };
  },
  name: "pet-catalog",
  components: {
    PetCard,
  },
  computed: {
    pets() {
      return this.$store.state.pets.filter(
        (pet) => pet.adoptionStatus == "Available"
      );
    },
    petsLen() {
      return this.pets.length;
    },
    middle() {
      if (this.end == 0) {
        return this.petsLen - 1;
      } else {
        return this.end - 1;
      }
    },
    end() {
      return (
        (((this.start + this.offset) % this.petsLen) + this.petsLen) %
        this.petsLen
      );
    },
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
  methods: {
    decrementStart() {
      if (this.start == 0) {
        this.start = this.petsLen - 1;
      } else {
        this.start--;
      }
    },
    incrementStart() {
      if (this.end >= this.petsLen - 1) {
        this.end = 0;
      }
      if (this.middle >= this.petsLen - 1) {
        this.middle = 0;
      }
      if (this.start >= this.petsLen - 1) {
        this.start = 0;
      } else {
        this.start++;
      }
    },
    noPetsMessage() {
      this.petsInArray = !this.petsInArray;
    },
  },
};
</script>

<style scoped>
.pet-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.arrow {
  width: 70px;
  height: 70px;
  align-self: center;
}
</style>