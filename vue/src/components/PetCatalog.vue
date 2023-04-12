<template>
  <div class="pet-container">
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
</template>

<script>
import PetService from "../services/PetService.js";
import PetCard from "./PetCard.vue";

export default {
  data() {
    return {
      start:0,
      offset:2,
      carArr:[],
    };
  },
  name: "pet-catalog",
  components: {
    PetCard,
  },
  computed: {
    pets() {
      return this.$store.state.pets;
    },
    petsLen(){
      return this.pets.length;
    },
    middle(){
      if(this.end==0){
        return this.petsLen-1;
      } else{
        return this.end-1;
      }
    },
    end(){
      return (((this.start+this.offset)%this.petsLen)+this.petsLen)%this.petsLen;
    }
  },
  created() {
    PetService.getAllPets().then((pets) => {
      this.$store.commit("SET_ALL_PETS", pets.data);
    });
  },
  methods: {
    decrementStart(){
      if(this.start==0){
        this.start=this.petsLen-1;
      }else{
        this.start--;
        }
      
    },
    incrementStart(){
      if(this.end>=this.petsLen-1){
        this.end=0;
      }if(this.middle>=this.petsLen-1){
        this.middle=0;
      }if(this.start>=this.petsLen-1){
        this.start=0;
      } else{
        this.start++;
      }
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