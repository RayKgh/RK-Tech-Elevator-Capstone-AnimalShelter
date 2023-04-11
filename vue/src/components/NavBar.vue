<template>
  
  <div id="nav" class="nav">
        <router-link v-bind:to="{ name: 'home' }">
          <img  src="https://i.imgur.com/rBJDZci.png" class="image" />
        </router-link> &nbsp;&nbsp;
    <div id="nav-items">
          <router-link v-bind:to="{ name: 'adopt' }" class="nav-item">
            Adopt
          </router-link>

          <div>
            <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" class="nav-item">
             Logout
            </router-link>

            <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token === ''" class="nav-item">
              Login
            </router-link>
          </div>
        
          <button class="volunteerList">
            <router-link v-bind:to="{ name: 'register' }" class="nav-item">
                Volunteer
            </router-link>
          </button>
    </div>

  </div>

</template>

<script>
export default {
name: "nav-bar",

methods: {

}
}
</script>

<style>
.nav {
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 130px;
  padding-left: 20px;
} 

.image {
  max-height: 100px;
}

#nav-items{
  display: flex;
  width: 40%;
  justify-content: space-around;
}

.nav-item {
  font-size: 25px;
  text-transform: uppercase;
  font-weight: 700;
  color: #f2ebe6;
  text-decoration: none;
}

.volunteerList {
  color: white;
  font-weight: bold;

}

button {
  border-radius: 50px;
  border: none;
  padding: 10px 30px;
   background-color: #de854e;
  font-size: 25px;
  padding: 10px 30px;
  text-transform: uppercase;
  text-decoration: none;
}
</style>