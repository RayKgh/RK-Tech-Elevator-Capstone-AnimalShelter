<template class="page">
  <div id="app">
    <div id="nav" class="nav">
      <router-link v-bind:to="{ name: 'home' }"
        ><img
          src="https://i.imgur.com/rBJDZci.png"
          class="image" /></router-link
      >&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <button class="adoptBtn">
      <router-link v-bind:to="{ name: 'adopt' }" class="petList">
        Adopt</router-link
      >
      </button>
      <button class="volBtn">
      <router-link v-bind:to="{ name: 'volunteer' }" class="volunteerList">
        Volunteer
      </router-link>
      </button>
    </div>
    <router-view />
  </div>


</template>

<script>
</script>

<style>

.nav {
  display: flex;
  border: dashed red;
  justify-content: space-between;
}

.image {
  padding: 25px;
  width: 10vh;
  height: 10vh;
}

.petList {
  color: white;
  font-weight: bold;
  font-family: "Poppins", sans-serif;
}

.volunteerList {
  color: white;
  font-weight: bold;
  font-family: "Poppins", sans-serif;

}

html,
body {
  background-image: url("https://i.imgur.com/d534hFp.png");
  background-size: 100%;
  background-color: #A19581;
  background-repeat: no-repeat;
}
.adoptBtn{

  border-radius: 16px;
  background-color: #de854e;
  padding: 15px 20px;
  
}

.volBtn{
   border-radius: 16px;
  background-color: #de854e;
  padding: 15px 50px;
}
</style>

