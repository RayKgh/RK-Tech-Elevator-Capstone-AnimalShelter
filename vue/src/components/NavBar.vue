<template>
  
  <div id="nav" class="nav">
        <router-link v-bind:to="{ name: 'home' }">
          <img  src="https://i.imgur.com/rBJDZci.png" class="image" />
        </router-link> &nbsp;&nbsp;

        <ul id="nav-items">
        
          <li>
              <router-link v-bind:to="{ name: 'adopt' }" class="petList">
                Adopt
              </router-link>
          </li>
          <li>
              <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != 'Login'">Login</router-link> -->
              Login
          </li>
          <li>
            <button>
                <router-link v-bind:to="{ name: 'register' }" class="volunteerList">
                  Volunteer
                </router-link>
        </button>
          </li>
        </ul>
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

#nav-items {
  display: flex;
  list-style: none;
  width: 35%;
  align-items: center;
  justify-content: space-between;
  padding-right: 30px;
}

#nav-items li {
  font-size: 25px;
  text-transform: uppercase;
  font-weight: 700;
  color: #f2ebe6;
}

#nav-items a{
  text-decoration: none;
}


.image {
  max-height: 100px;
}

.petList {
  color: white;
  font-weight: bold;
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