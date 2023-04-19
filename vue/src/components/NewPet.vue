<template>
  <div class="page">
    <h2>New Pet</h2>

    <form @submit.prevent="newSubmit()" class="form">
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

          <select name="sex" id="sex" v-model="pet.sex">
            <option
              v-for="(sex, index) in pet.sexOptions"
              :key="index"
              :value="sex.text"
            >
              {{ sex.text }}
            </option>
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
          <select name="color" id="color" v-model="pet.color">
            <option
              v-for="(color, index) in pet.colorOptions"
              :key="index"
              :value="color.text"
            >
              {{ color.text }}
            </option>
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
              placeholder="*Required*"
              class="required"
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
              @change="updateURL()"
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
      url: "",
      pet: {
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
        vaccinated: false,
        petDescription: "",
        dob: "",
        source: "",
        photoDescription: "",
      },
    };
  },
  methods: {
    updateURL() {
      this.url = this.pet.source;
    },
    newSubmit() {
      //checks to see if all fields left blank. if so, will not create pet.
      if (
        this.pet.petName == "" &&
        this.pet.color == "" &&
        this.pet.breed == "" &&
        this.pet.sex == "" &&
        this.pet.vaccinated == false &&
        this.pet.petDescription == "" &&
        this.pet.dob == "" &&
        this.pet.source == "" &&
        this.pet.photoDescription == ""
      ) {
        alert("No Pet Created. Need to input pet details");
      } else if (this.pet.petName == "") {
        alert("Sloth needs at least a name");
      } else if (this.url === "") {
        this.submit();
      } else {
        this.isImgUrl(this.url).then((response) => {
          if (response === true) {
            this.submit();
          } else {
            alert("The photo source is not valid");
          }
        });
      }
    },
    isImgUrl(url) {
      const img = new Image();
      img.src = url;
      return new Promise((resolve) => {
        img.onload = () => resolve(true);
        img.onerror = () => resolve(false);
      });
    },
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
        dob: this.pet.dob == "" ? null : this.pet.dob,
        source:
          this.pet.source == ""
            ? "https://i.imgur.com/gYePOeR.png"
            : this.pet.source,
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

.section-three {
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
  padding-right: 600px;
  padding-top: -50px;
  text-align: center;
  font-size: 50px;
  text-transform: uppercase;
  color: #335137;
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
  /* margin: 50px 100px 175px; */
  width: 900px;
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

.required::placeholder {
  /* Chrome, Firefox, Opera, Safari 10.1+ */
  color: red;
  opacity: 1; /* Firefox */
}
</style>