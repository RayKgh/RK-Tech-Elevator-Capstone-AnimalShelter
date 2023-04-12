<template>
  <div class="home">
    <h1>Cincy Sloths</h1>
    <p>Volunteer run sloth rescue for cincinnati's sleepiest residents</p>
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
    margin: 50px 30px 0;
    /* background-color: tomato; */
    width: 50%;
  }

  p {
    margin: -20px 20px 0;
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

</style>
