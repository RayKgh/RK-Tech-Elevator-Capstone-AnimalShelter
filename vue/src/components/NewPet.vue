<template>
  <div>
    <h2>Add new pet details</h2>
   
    <form @submit.prevent="submit()" class="form">
      <div class="name">
        <label for="name">Name</label>
        <input
          type="text"
          name="name"
          id="name"
          v-model="pet.petName"
          placeholder="Lightning"
        />
      </div>

      <div class="color">
        <label for="color">Color</label>
        <input
          type="text"
          name="color"
          id="color"
          v-model="pet.color"
          placeholder="Brown"
        />
      </div>

      <div class="breed">
        <label for="breed">Breed</label>
        <input
          type="text"
          name="breed"
          id="breed"
          v-model="pet.breed"
          placeholder="Two-Toed/Three-Toed"
        />
      </div>

      <div class="sex">
        <label for="sex">Sex</label>
        <input
          type="text"
          name="sex"
          id="sex"
          v-model="pet.sex"
          placeholder="M/F"
        />
      </div>

    
      <div class="vaccination">
        <h3> Are they Vaccinated? </h3>
      <div class="vaccine">
        <section class="yes">
        <label for="is-vaccinated">yes</label>
        <input
          type="checkbox"
          name="vaccinated"
          id="vaccinated"
          @change="changeVaccinatedStatus()"
        />
        </section>

      <section class="no">
         <label for="is-vaccinated"> no</label>
        <input
          type="checkbox"
          name="vaccinated"
          id="vaccinated"
          @change="changeVaccinatedStatus()"
        />
        </section>
        </div>
      </div>

      <div class="describe">
        <label for="description">Description of Sloth</label>
        <textarea
          type="text"
          name="desciption"
          id="description"
          v-model="pet.petDescription"
        />
      </div>

      <div class="date">
        <label for="date">Sloth's Date of Birth</label>
        <input
          type="date"
          name="dob"
          id="dob"
          v-model="pet.dob"
          placeholder="06/12/2003"
        />
      </div>

      <div class="photo-url">
        <label for="photoUrl"> Add Photo Url </label>
        <input
          type="text"
          name="photoUrl"
          id="photoUrl"
          v-model="pet.source"
          placeholder="https://www.google.com/imgres?imgurl"
        />
      </div>

      <div class="photo-describe">
        <textarea
          type="text"
          name="description"
          id="description"
          v-model="pet.description"
        />
        <label>Add Description of Photo</label>
      </div>

      <div class="submit-btn">
        <button type="submit" id="submit-btn">submit</button>
      </div>
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
    methodToForceUpdate() {
      this.$forceUpdate();
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
  },
};
</script>

<style scoped>
h2 {
  color: #59351f;
  font-weight: 800;
  font-size: 50px;
  padding-left: 80px;
}

.form {
  display: flex;
  flex-direction: column;
  padding-left: 70px;
  width: 800px;
  padding-top: 10px;
}

.name {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
  font-size: 20px;
}

#name {
  border-radius: 50px;
}

.color {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
  font-size: 20px;
  padding-top: 20px;
}

#color {
  border-radius: 50px;
}

.breed {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
  font-size: 20px;
  padding-top: 20px;
}

#breed {
  border-radius: 50px;
}

.sex {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
  font-size: 20px;
  padding-top: 20px;
}
#sex {
  border-radius: 50px;
}

.vaccination {
  display: flex;
  justify-content: space-evenly;
  padding-top: 20px;

}

.vaccine{
  display: flex;
 
  
}

#vaccinated{
 
  width: 15px;
  height: 15px;
  
}

.describe {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
  font-size: 20px;
  padding-top: 20px;
}

#description {
  border-radius: 50px;
}

.date {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
  font-size: 20px;
  padding-top: 20px;
}

#dob {
  border-radius: 50px;
  padding-left: 10px;
}

.photo-url {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column;
  font-size: 20px;
  padding-top: 20px;
}

#photoUrl {
  border-radius: 50px;
}

.photo-describe {
  display: flex;
  justify-content: space-evenly;
  flex-direction: column-reverse;
  font-size: 20px;
  padding-top: 30px;
}

.submit-btn {
  padding-top: 10px;
}

#submit-btn {
  border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #de854e;
  color: #f2ebe6;
  padding: 8px 25px;
  margin-top: 20px;
  font-weight: 800;
  font-size: 20px;
  text-transform: uppercase;
}

input {
  font-size: 17px;
  color: #335137;
  font-weight: 300;
  outline: none;
  background-color: #f2ebe6;
  outline: none;
  text-decoration: none;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  height: 30px;
}

label {
  font-size: 16px;
  color: #335137;
  margin-bottom: 0;
  font-weight: 700;
}

input::placeholder {
   padding-left: 15px;
}

h3{
   font-size: 16px;
  color: #335137;
  margin-bottom: 0;
  font-weight: 700;
  padding-left: 20px;
  font-size: 20px;
}

.yes{
padding-left: 30px;
}

.no{
  padding-left: 60px;
}

</style>