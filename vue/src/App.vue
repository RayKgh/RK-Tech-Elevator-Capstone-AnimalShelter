<template class="page">
  <div id="app">
    <nav-bar />
    <router-view />
  </div>
</template>

<script>
import NavBar from "./components/NavBar.vue";

export default {
  components: {
    NavBar,
  },
};
</script>

<style>
html,
body {
  background-image: url("https://i.imgur.com/d534hFp.png");
  background-size: 100%;
  background-color: #d1cdc7;
  background-repeat: no-repeat;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}
</style>

