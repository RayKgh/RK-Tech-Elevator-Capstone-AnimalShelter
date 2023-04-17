<template>
  <div class="page">
    <h2>Add new pet details</h2>

    <form @submit.prevent="submit()" class="form">
      <div class="section-one">
        <div class="breed">
          <label for="breed">Choose a Breed:</label>

          <select name="breed" id="breed">
            <option value="pygmy">Pygmy three-toed sloth</option>
            <option value="maned">Maned sloth</option>
            <option value="pale-throated">Pale-throated sloth</option>
            <option value="brown-throated">Brown-throated sloth</option>
            <option value="linnaeus">Linnaeus’s two-toed sloth</option>
            <option value="hoffman">Hoffman’s two-toed sloth</option>
          </select>
          <!-- <label>Breed</label>
    <div id="breed-id">
        <input
          type="text"
          name="breed"
          id="breed"
          v-model="pet.breed"
          placeholder="Two-Toed/Three-Toed"
        />
        </div> -->
        </div>
        <div class="sex">
          <label for="sex">Choose the Sex:</label>

          <select name="sex" id="sex">
            <option value="male">Male</option>
            <option value="female">Female</option>
          </select>
          <!-- <label>Sex</label>
         <div id="sex-id">
        <input
          type="text"
          name="sex"
          id="sex"
          v-model="pet.sex"
          placeholder="M/F"
        />
        </div> -->
        </div>

        <div class="color">
          <label for="color">Choose the color:</label>
          <select name="color" id="color">
            <option value="brown">Brown</option>
            <option value="grey">Grey</option>
            <option value="black">Black</option>
            <option value="white">White</option>
            <option value="green">Green</option>
          </select>

          <!-- <label>Color</label>
        <div id="color-id">
        <input
          type="text"
          name="color"
          id="color"
          v-model="pet.color"
          placeholder="Brown"
        />
      </div> -->
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

        <div class="vaccinated">
          <label> Are they Vaccinnated? Check if yes: </label>
          <div id="vac-id">
            <input
              type="checkbox"
              name="vaccinated"
              id="vaccinated"
              @change="changeVaccinatedStatus()"
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
.page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
}

.section-one {
  /* width: 2000px;
  height: 200px; */
  margin: 20px;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  /* border: dashed blue; */
}

.section-two {
  margin: 20px;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  /* justify-items: center; */
  /* border: dotted black; */
}

.section-three {
  margin: 20px;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  /* border: double yellow; */
}

#name-id * input {
  width: 180px;
}

h2 {
  font-weight: 900;
  margin: 30px 0 0 0;
  text-align: center;
  font-size: 40px;
  text-transform: uppercase;
  color: #59351f;
}

form * input {
  padding: 10px 10px 10px 20px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  border-radius: 50px;
  /* border: dotted black; */
  width: 250px;
  background-color: #f2ebe6;
}

form * textarea {
  padding: 10px 10px 10px 20px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  border-radius: 50px;
  /* border: dotted black; */
  width: 100%;
  height: 150px;
  background-color: #f2ebe6;
}

form * select {
  padding: 10px 10px 10px 20px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  border-radius: 50px;
  /* border: dotted black; */
  width: 250px;
  background-color: #f2ebe6;
}

.form {
  display: flex;
  flex-direction: column;
  /* border: dashed red; */
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

.pet-desc {
  display: flex;
  flex-direction: column;
  margin: 20px;
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
  color: #f2ebe6;
  padding: 8px 25px;
  margin-top: 20px;
  font-weight: 800;
  font-size: 20px;
  text-transform: uppercase;
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
  /* background-color: #f2ebe6; */
  /* border: dotted blue; */
}

input::placeholder {
  padding-left: 15px;
}

select {
  border-radius: 50px;
  width: 70px;
}
</style>