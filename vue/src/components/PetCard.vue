<template>
  <div class="card">
    <div class="inner">
      <div class="front">
        <pet-photos v-bind:pet="pet" class="image" />
        <h2 class="name">{{ pet.petName }}</h2>
        <ul>
          <li><strong>Sex:</strong> {{ pet.sex }}</li>
          <li><strong>Species:</strong> {{ pet.breed }}</li>
          <li><strong>Coloration:</strong> {{ pet.color }}</li>
          <li><strong>Age:</strong> {{ this.ageCalc }}</li>
        </ul>
      </div>
      <div class="back">
        <div id="bio">
          <p class="description">{{ pet.petDescription }}</p>
        </div>
      </div>
      <!-- <router-link
      :to="{ name: 'adopt-pet', params: { id: pet.petID } }"
      class="button"
      >More {{ pet.petName }}</router-link
    > -->
    </div>
  </div>
</template>

<script>
import PetPhotos from "./PetPhotos.vue";
import PetPhotoService from "../services/PetPhotoService.js";
export default {
  components: { PetPhotos },
  created() {
    PetPhotoService.getAllPetPhotos().then((photos) => {
      this.$store.commit("SET_PHOTOS", photos.data);
    });
  },
  name: "pet-card",
  props: ["pet"],
  data() {
    return {
      isFlipped: false,
    };
  },
  computed: {
    ageCalc() {
      if (this.pet.dob != null) {
        let birthDate = new Date(this.pet.dob);
        let birthDays =
          birthDate.getDay() +
          birthDate.getMonth() * 30 +
          birthDate.getFullYear() * 365;
        let nowDate = new Date();
        let nowDays =
          nowDate.getDay() +
          nowDate.getMonth() * 30 +
          nowDate.getFullYear() * 365;

        let age = Math.floor((nowDays - birthDays) / 365);
        return age;
      } else {
        return "No Birthday Given";
      }
    },
  },
};
</script>

<style scoped>
.image {
  min-height: 50%;
  max-height: 50%;
  min-width: 100%;
  overflow: hidden;
}

.card {
  width: 40vh;
  height: 70vh;
  perspective: 1000px;
  margin: 10px;
}

.inner {
  display: flex;
  flex-direction: column;
  align-items: center;
  position: relative;
  box-shadow: 0px 16px 16px rgba(0, 0, 0, 0.2);
  border-radius: 30px;
  height: 100%;
  width: 100%;
  transition: 1s;
  transform-style: preserve-3d;
}

.front,
.back {
  background-color: #f2ebe6;
  border-radius: 30px;
  position: absolute;
  overflow: hidden;
  height: 100%;
  width: 100%;
  /* display: flex;
  justify-content: center;
  align-items: center; */
  backface-visibility: hidden;
}

.back {
  display: flex;
  /* justify-content: center;
  align-items: center; */
  transform: rotateY(180deg);
}

.card:hover .inner {
  transform: rotateY(180deg);
}

.name {
  margin-left: 25px;
}

.button {
  display: none;
  background-color: #de854e;
  font-size: 20px;
  color: #f2ebe6;
  align-items: flex-end;
  margin: 0 3px 3px 3px;
  margin-top: auto;
  margin-left: auto;
  border-radius: 25%;
  min-width: 40%;
  max-width: 50%;
  justify-content: center;
  align-items: center;
  min-height: 10%;
}

ul {
  list-style-type: none;
  margin-top: 10px;
  align-self: flex-start;
  margin-left: 25px;
  margin-bottom: 10px;
}

#bio {
  display: flex;
  flex-grow: 2;
  align-self: stretch;
  flex-wrap: wrap;
  overflow-y: auto;
  margin-bottom: 10px;
}

::-webkit-scrollbar {
  background-color: #f2ebe6;
}

::-webkit-scrollbar-thumb {
  background-color: #b3afaf;
  border-radius: 20px;
  background-clip: content-box;
  border: solid 5px transparent;
}

.description {
  flex-grow: 1;
  margin: 5px;
  font-size: 15px;
  text-transform: none;
}
</style>