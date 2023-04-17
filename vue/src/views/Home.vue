<template>
  <div class="home">
    <h1>Cincy Sloths</h1>
    <h2>Volunteer-run sloth rescue for cincinnati's sleepiest residents</h2>
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

h1 {
  font-size: 120px;
}

h2 {
  margin: -20px 20px 0;
  font-size: 50px;
  text-transform: uppercase;
  /* background-color: aliceblue; */
  width: 700px;
  color: #59351f;
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

@media screen and (max-width: 1680px) {
  h1 {
    font-size: 90px;
  }

  h2 {
    font-size: 30px;
    width: 400px;
  }

  .browse-btn {
    border-radius: 50px;
    border: transparent;
    background-color: #de854e;
    text-transform: uppercase;
    padding: 12px 25px;
    margin: 10px 20px;
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

@media screen and (max-width: 1400px) {
  .home {
    margin: 100px 30px 0 50px;
    /* background-color: tomato; */
    width: 60%;
  }

  h1 {
    font-size: 70px;
    margin-bottom: -10px;
    margin-left: -10px;
  }

  h2 {
    font-size: 30px;
    width: 400px;
    margin: 0;
  }

  .browse-btn {
    margin: 10px 0px;
  }
}

@media screen and (max-width: 900px) {
  .home {
    margin: 150px 30px 0 80px;
    /* background-color: tomato; */
    width: 60%;
  }

  h1 {
    font-size: 50px;
    margin: -10px 0px;
    /* background-color: pink; */
  }

  h2 {
    font-size: 30px;
    width: 400px;
    margin: 0;
  }
}

@media screen and (max-width: 800px) {
  .home {
    /* background-color: magenta; */
    margin: 100px 20px;
  }
}

@media screen and (max-width: 600px) {
  .home {
    /* background-color: magenta; */
    margin: 100px 20px;
    width: 90%;
  }
}
</style>
