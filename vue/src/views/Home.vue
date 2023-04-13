<template>
  <div class="home">
    <h1>Cincy Sloths</h1>
    <h2>Volunteer run sloth rescue for cincinnati's sleepiest residents</h2>
    <button class="browse-btn">
        <router-link :to="{ name: 'adopt' }" class="btn-text">
          Available Pets
        </router-link>
      </button>
  </div>
</template>

<script>
export default {
  name: "home",
 
};
</script>

<style scoped> 

  .home {
    margin: 150px 30px 0 100px;
    /* background-color: tomato; */
    width: 60%;
  }

  h1{
    font-size: 120px;
  }

  h2 {
    margin: -20px 20px 0;
    font-size: 50px;
    text-transform: uppercase;
    /* background-color: aliceblue; */
    width: 700px;
    color: #59351F;


  }
  

  .browse-btn {
    border-radius: 50px;
    border: transparent;
    background-color: #de854e;
    text-transform: uppercase;
    padding: 15px 50px;
    margin: 20px 20px 0;
  }

  .btn-text {
  font-weight: bold;
  color: #f2ebe6;
  font-family: "Poppins", sans-serif;
  text-decoration: none;
  text-transform: uppercase;
  font-size: 30px;
}

@media screen and (max-width: 1650px) {

  h1{
    font-size: 90px;
  }
   h2{
     font-size: 30px;
     width: 500px
   }
}

@media screen and (max-width: 1400px) {

  h1{
    font-size: 70px;
    margin-bottom: -10px;
  }

  h2{
     font-size: 30px;
     width: 500px;
     margin: 0;
    }

  .browse-btn {
    border-radius: 50px;
    border: transparent;
    background-color: #de854e;
    text-transform: uppercase;
    padding: 12px 25px;
    margin: 5px 0;
    }

  .btn-text {
  font-weight: bold;
  color: #f2ebe6;
  font-family: "Poppins", sans-serif;
  text-decoration: none;
  text-transform: uppercase;
  font-size: 20px;
}
}

</style>
