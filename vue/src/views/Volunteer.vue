<template>
  <div class="volunteer-page">
    <div class="volunteer">
    <h1>Why Volunteer?</h1>

    <p> As a 100% volunteer run organization we are always looking for energetic and passionate folks who wish to give their time to help our cause. </p>
  
    <form @submit.prevent="submit">
        <h2> Sign Up Today! </h2>

        <div id="names">
          <div id="first-name">
            <label for="fname">First Name</label>
            <input v-model="applicant.firstName" type="text" id="fname" name="fname" placeholder="Dolly" required>  
          </div>

          <div id="last-name">
            <label for="lname">Last name</label>
            <input v-model="applicant.lastName" type="text" id="lname" name="lname" placeholder="Parton" required>
          </div>
        </div>

        <div id="email-div" class="input-box"> 
          <label for="email">Email</label>
          <input v-model="applicant.email" type="email" id="email" name="email" placeholder="DollyParton@email.com" required>
        </div>

        <div id="phone-div" class="input-box">
          <label for="phonenum">Phone</label>
          <input v-model="applicant.phoneNum" type="tel" id="phonenum" name="phonenum"  maxlength="10" placeholder="9251234567" required> 
        </div>

        <div id="bday-submit">
          <div id="bday-box">
            <label for="dob">Birthday</label>
            <input v-model="applicant.dob" type="date" id="dob" name="dob" value="01/19/1946" required>
          </div>

          <div id="bday-btn">
             <button type="submit" class="submitreg"> Submit </button>
          </div>
        </div>
    </form>

   
    </div>

   <div class="signedup">
      <h3>Already a volunteer?</h3>
      <button class="sign-in">
        <router-link :to="{ name: 'login' }" class="sign-in-link">
          Sign in here!
        </router-link>
      </button>
    </div>
  </div>
  

</template>

<script>
import axios from 'axios';

export default {
    name: 'volunteer',
    data() {
      return {
        applicant: {
          firstName: "",
          lastName: "",
          dob: "",
          phoneNum: "",
          email: ""
        },
      };
    },
    methods: {
      submit() {
         axios.post('/volunteer', this.applicant)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({name: "home"});
            }
          })
          .catch(() => {
            alert("Volunteer Application was not able to submit. Refresh Page and try again.")
          })
      } 
    }
       
}
</script>

<style scoped>

.volunteer-page{
  display: flex;
  justify-content: space-between;

}

h1{
  
  font-size: 65px;
  margin: 20px 80px 0;
  
}

p {
  width: 620px;
  margin: -15px 80px 0 80px;
  font-size: 25px;
  text-transform: none;
}

form {
  margin-left: 100px;
  width: 380px;
  margin-bottom: 250px;

}

h2{
  font-weight: 900;
  margin: 30px 0 0 0;
  text-align: center;
  font-size: 40px;
  text-transform: uppercase;
  color: #59351F;
}

form * input {
  padding: 10px 10px 10px 20px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  border-radius: 50px;
  border: none;
  width: 100%;
}

#names * input {
  width:    180px;
  
}

label{
  font-size: 16px;
  color: #335137;
  margin-bottom: 0;
  font-weight: 700;
  text-transform: uppercase;
}


input{
  font-size: 17px;
  color: #335137;
  font-weight: 300;
  outline: none;
  background-color: #f2ebe6;
  
}

.input-box {
  display: flex;
  flex-direction: column;
  padding: 0;
}

.input-box > label {
  padding: 0 20px;
}


input:focus,
select:focus,
textarea:focus,
button:focus {
    outline: none;
}

#names{
  display: flex;
  justify-content: space-between;
  align-items: center;
}



#names > div {
  display: flex;
  flex-direction: column;
  padding: 0 0px;
}

#names * label {
  padding: 0 20px;
}

.signedup{
  display: flex;
  flex-direction: column;
  font-weight: 800;
  font-size: 40px;
  text-transform: uppercase;
  margin: 0px 70px 0 0;
  width: 30%;
  height: 50%;
  padding: 0;
  padding-top: 10%;
  align-self: flex-end;
  align-items: flex-end;
}

.sign-in{
  border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #de854e;
  padding: 10px 50px;
  margin-top: 20px;
  font-size: 25px;
  text-decoration: none;
  text-transform: uppercase;
}

.sign-in-link{
  font-weight: bold;
  color: #f2ebe6;
  text-decoration: none;
  font-weight: 800;
}


form > * {
  margin-bottom: 5px;
}

#bday-box {
  padding: 0 40px 0 0;
}

#bday-box > label {
  padding: 0 20px;
}



#bday-submit{
  display: flex;
  justify-content: space-between;
  align-items: center;
}



.submitreg{
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

.submitreg > button {
  color: red;
}

h3 {
  font-size: 50px;
  color: #f2ebe6;
  text-align: right;
  font-weight: 800;
}


</style>