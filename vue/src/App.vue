<template class="page">
  <div id="app">
    <div id="nav">
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
      <router-link v-bind:to="{ name: 'adopt' }" class="petList">
        Adopt</router-link
      >
      <router-link v-bind:to="{ name: 'volunteer' }" class="volunteerList">
        Volunteer
      </router-link>
    </div>
    <router-view />
  </div>

  <!-- tag="img" src="https://i.imgur.com/rBJDZci.png"/ -->
</template>

<script>
</script>

<style>
.nav {
  padding-top: 25px;
  padding-bottom: 25px;
  padding-left: 75vh;
  padding-right: 75vh;
}

.image {
  padding: 25px;
  width: 10%;
  height: 10vh;
}

.petList {
  padding-left: 75vh;
  padding-right: 75vh;
}

.volunteerList {
  padding-left: 75vh;
  padding-right: 75vh;
}

html,
body {
  background-image: url("https://i.imgur.com/d534hFp.png");
  background-size: 100%;

  background-repeat: no-repeat;
}
</style>

