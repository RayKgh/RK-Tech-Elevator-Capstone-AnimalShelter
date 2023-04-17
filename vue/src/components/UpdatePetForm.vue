<template>
  <div class="page">
    <h2>Update {{ this.pet.petName }}'s details</h2>
    <form @submit.prevent="submit" class="form">
      <div class="section-one">
        <div class="breed">
          <label for="breed">Choose a Breed:</label>

          <select name="breed" id="breed" v-model="pet.breed">
            <option
              v-for="(breed, index) in pet.breedOptions"
              :key="index"
              :value="breed.text"
            >
              {{ breed.text }} sloth
            </option>
          </select>
        </div>

        <div class="sex">
          <label for="sex">Choose the Sex:</label>

          <select name="sex" id="sex" v-model="pet.sex">
            <option
              v-for="(sex, index) in pet.sexOptions"
              :key="index"
              :value="sex.text"
            >
              {{ sex.text }}
            </option>
          </select>
        </div>

        <div class="color">
          <label for="color">Choose the color:</label>
          <select name="color" id="color" v-model="pet.color">
            <option
              v-for="(color, index) in pet.colorOptions"
              :key="index"
              :value="color.text"
            >
              {{ color.text }}
            </option>
          </select>
        </div>
      </div>
      <div class="section-two">
        <div class="name">
          <label>Enter Sloth Name: </label>
          <div id="name-id">
            <input
              type="text"
              name="name"
              id="name"
              v-model="pet.petName"
              placeholder="Lightning"
            />
          </div>
        </div>

        <div class="vaccinated">
          <label>
            Is {{ pet.petName }} Vaccinated? Click if {{ !pet.vaccinated }}:
          </label>
          <div id="vac-id">
            <input
              type="checkbox"
              name="vaccinated"
              id="vaccinated"
              @change="changeVaccinatedStatus()"
            />
          </div>
        </div>

        <div class="dob">
          <label>Enter Date of Birth: </label>
          <div id="dob-id">
            <input
              type="date"
              name="dob"
              id="dob"
              v-model="pet.dob"
              placeholder="06/12/2003"
            />
          </div>
        </div>
      </div>

      <div class="section-three">
        <div class="photo-url">
          <label>Enter a photo url:</label>
          <div id="url-id">
            <textarea
              type="text"
              name="photoUrl"
              id="photoUrl"
              v-model="pet.source"
              placeholder="https://www.google.com/imgres?imgurl"
            />
          </div>
        </div>

        <div class="pet-desc">
          <label>Enter Description of Sloth: </label>
          <div id="pet-id">
            <textarea
              type="text"
              name="desciption"
              id="description"
              v-model="pet.petDescription"
            />
          </div>
        </div>

        <div class="photo-desc">
          <label>Enter Description of Photo:</label>
          <div id="photo-id">
            <textarea
              type="text"
              name="description"
              id="description"
              v-model="pet.description"
            />
          </div>
        </div>
      </div>

      <div class="section-four">
        <div class="entry-date">
          <label>When {{ pet.petName }} Was Rescued</label>
          <input
            type="date"
            name="entryDate"
            id="entryDate"
            v-model="pet.entryDate"
            placeholder="06/12/2003"
          />
        </div>
        <div class="adoption-status">
          <label>Select {{ pet.petName }}'s Adoption Status </label>
          <select
            name="adoption-status"
            id="adoption-status"
            v-model="pet.adoptionStatus"
          >
            <option
              v-for="(status, index) in pet.adoptionOptions"
              :key="index"
              :value="status.text"
            >
              {{ status.text }}
            </option>
          </select>
        </div>

        <div class="adoption-date">
          <label>When {{ pet.petName }} Was Adopted</label>
          <input
            type="date"
            name="adoptionDate"
            id="adoptionDate"
            v-model="pet.adoptionDate"
            placeholder="06/12/2003"
          />
        </div>
      </div>

      <div class="submit-btn">
        <button type="submit" id="submit-btn">Submit Updates</button>
      </div>
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
        colorOptions: [
          { text: "Brown" },
          { text: "Black" },
          { text: "Grey" },
          { text: "White" },
          { text: "Green" },
        ],
        breed: "",
        breedOptions: [
          { text: "Hoffman two-toed" },
          { text: "Maned" },
          { text: "Pale-throated" },
          { text: "Brown-throated" },
          { text: "Linnaeus two-toad" },
          { text: "Pygmy three-toed" },
        ],
        sex: "",
        sexOptions: [{ text: "Male" }, { text: "Female" }],
        vaccinated: "",
        petDescription: "",
        dob: "",
        adoptionDate: "",
        adoptionStatus: "",
        adoptionOptions: [
          {
            text: "Available",
          },
          { text: "Adopted" },
        ],
        entryDate: "",
        source: "",
        description: "",
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
    //takes data from pets() in computed and puts in pet in data
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
      this.pet.description = this.pets[0].description;
      this.pet.source = this.pets[0].source;
    },
    methodToForceUpdate() {
      this.$forceUpdate();
    },
    submit() {
      const updatedPet = {
        petName: this.pet.petName,
        color: this.pet.color,
        breed: this.pet.breed,
        sex: this.pet.sex,
        vaccinated: this.pet.vaccinated,
        petDescription: this.pet.petDescription,
        dob: this.pet.dob == "" ? null : this.pet.dob,
        source: this.pet.source,
        photoDescription: this.pet.photoDescription,
        entryDate: this.pet.entryDate == "" ? null : this.pet.entryDate,
        adoptionDate:
          this.pet.adoptionDate == "" ? null : this.pet.adoptionDate,
        adoptionStatus: this.pet.adoptionStatus,
        petID: this.pets[0].petID,
        //ternary operators check for empty string because jave LocalDate.parse() doesn't like that.
      };

      PetService.updatePet(updatedPet)
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
#vac-id {
  display: flex;
}

.page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
}

.section-one {
  margin: 20px;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

.section-two {
  margin: 20px;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

.section-three,
.section-four {
  margin: 20px;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

#name-id * input {
  width: 180px;
}

h2 {
  font-weight: 900;
  margin: 30px 0 0 0;
  text-align: center;
  font-size: 60px;
  text-transform: uppercase;
  color: #59351f;
}

form * input {
  padding: 10px 10px 10px 20px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  border-radius: 50px;

  width: 250px;
  background-color: white;
}

form * textarea {
  padding: 10px 10px 10px 20px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  border-radius: 20px;

  width: 100%;
  height: 150px;
  background-color: #f2ebe6;
  background-color: white;
}

form * select {
  padding: 10px 10px 10px 20px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  border-radius: 50px;

  width: 250px;
  background-color: #f2ebe6;
  background-color: white;
}

.form {
  display: flex;
  flex-direction: column;

  margin: 50px 100px 175px;
  width: 900px;
  /* background: repeating-linear-gradient(
#f2ebe6 ,
 #de854e 10px,
#de854e 10px,
#de854e 11px
); */
  /* background-color:  #de854e;
border: thick double white */

  background-color: #f2ebe6;
  border: thick double #de854e;
}

.name {
  display: flex;
  flex-direction: column;
  margin: 20px;
}

.color {
  display: flex;
  flex-direction: column;
  margin: 20px;
}

.breed {
  display: flex;
  flex-direction: column;
  margin: 20px;
}

.vaccinated {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin: 20px;
}

#vaccinated {
  width: 15px;
  height: 15px;
}

.sex {
  display: flex;
  flex-direction: column;
  margin: 20px;
}

.pet-desc,
.adoption-status {
  display: flex;
  flex-direction: column;
  margin: 20px;
}

.adoption-status {
  margin-top: 0;
}

.photo-desc {
  display: flex;
  flex-direction: column;
  margin: 20px;
}

.dob {
  display: flex;
  flex-direction: column;
  margin: 20px;
}

.photo-url {
  display: flex;
  flex-direction: column;
  margin: 20px;
}

.submit-btn {
  padding-top: 10px;
  display: flex;
  justify-content: center;
}

#submit-btn {
  border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #de854e;
  color: white;
  padding: 8px 25px;
  margin-top: 20px;
  font-weight: 800;
  font-size: 20px;
  text-transform: uppercase;
  margin: 20px;
}

label {
  font-size: 16px;
  color: #335137;
  margin-bottom: 0;
  font-weight: 700;
  text-transform: uppercase;
}

input {
  display: table;
  font-size: 17px;
  color: #335137;
  font-weight: 300;
  outline: none;
}

input::placeholder {
  padding-left: 15px;
}

select {
  border-radius: 50px;
  width: 70px;
}
</style>