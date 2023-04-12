<template>
  <div class="pitch">
      <h1>Why Volunteer?</h1>
      <section> As a 100% volunteer run organization we are always looking for energetic and passionate folks who wish to give their time to help our cause. </section>
<div class="create-reg">
    <h2> Sign Up Today! </h2>
</div>
<form>
<div id="names">
<input type="text" id="fname" name="fname" placeholder="first name">
<input type="text" id="lname" name="lname" placeholder="last name">
</div>

<div id="email-div"> 
<input type="text" id="email" name="email" placeholder="email address">
</div>

<div id="phone-div"> 
<input type="text" id="phonenum" name="phonenum" placeholder="Phone Number">
</div>

<div id="bday-submit">
<input type="text" id="dob" name="dob" placeholder="Date-of-birth">
  <button type="submit" class="submitreg">
          Submit
      </button>
</div>
</form>
 <div class="signedup">
      <h3>Already a volunteer?</h3>
      <button class="sign-in">
        <router-link :to="{ name: 'home' }" class="sign-inpage">
          Sign in here!
        </router-link>
      </button>
    </div>
  </div>

</template>

<script>
export default {
     name: 'register',
}
</script>

<style scoped>

h1{
  font-size: 80px;
  padding-left: 5%;
}

section{
  display: flex;
  justify-content: center;
  width: 37%;
  padding-left: 5%;
  font-size: 30px;
  /* border: dashed white; */
}

.create-reg{
  padding-top: 1%;
  font-size: 30px;
  padding-left: 10%;
  /* border: dashed red; */
}

h2{
  font-weight: 800;
  margin-bottom: 30px;
}

#fname{
  padding: 5px 5px 5px 5px;
  border-radius: 50px;
}

#lname{
   padding: 5px 5px 5px 5px;

  border-radius: 50px;
  
}

#email{
   padding: 5px 5px 5px 5px;
   border-radius: 50px;
   width: 30%;
}

#phonenum{
   padding: 5px 5px 5px 5px;
    border-radius: 50px;
   width: 30%;
}

#dob{
   padding: 5px 5px 5px 5px;
   border-radius: 50px;
  
}

label{
  font-size: 30px;
}


input{
  font-size: 25px;
  color: #59351F;
  font-weight: 600;
  margin: 0;
  
}

input:focus,
select:focus,
textarea:focus,
button:focus {
    outline: none;
}

.submitreg{
   border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #de854e;
  color: #f2ebe6;
  padding: 10px 70px;
  margin-top: 20px;
  font-weight: 800;
  font-size: 25px;
  text-transform: uppercase;
}

#bday-submit{
  display: flex;
  justify-content: space-between;
  width: 30%;
}

#names{
  display: flex;
  justify-content: space-between;
  width: 30%;
}

#names > input {
  margin-right: 20px;
}

.signedup{
  display: flex;
  flex-direction: column;
  align-items: center;
  font-weight: 800;
  color: #f2ebe6;
  font-size: 40px;
  text-transform: uppercase;
  align-self: flex-end;
  margin: 0 250px 0 0;
  width: 30%;
  height: 50%;
  padding: 0;
  padding-left: 70%;
  padding-top: 10%;
}

.sign-in{
   border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #de854e;
  padding: 10px 50px;
  margin-top: 20px;
  font-size: 30px;
  text-transform: uppercase;
}

.signedup{
   font-weight: bold;
  color: #f2ebe6;
  text-decoration: none;
  font-weight: 800;
}

form{
  /* border: dashed blue; */
  padding-left: 5%;
}

form > * {
  margin-bottom: 20px;
}
</style>