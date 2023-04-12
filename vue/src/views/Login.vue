<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1>Login, Please.</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          v-model="user.username"
          required
          autofocus
          class="userName"
        />
        <label for="password">Password</label>
        <input
          type="password"
          id="password"
          v-model="user.password"
          required
          class="passWord"
        />
      </div>
      <button type="submit" class="signIn">
          Sign in
      </button>
    </form>
    <div class="registervol">
      <h2>Not registered as a volunteer?</h2>
      <button class="regBtn">
        <router-link :to="{ name: 'register' }" class="page-btn">
          Sign up Now!
        </router-link>
      </button>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push({name: "home"});
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
form {
  display: flex;
  flex-direction: column;
  /* justify-content: space-evenly; */
  /* background-color: aliceblue; */
  height: 70vh;
  margin-left: 5%;
  align-self: flex-start;
  margin-top: 50px;
  align-items: flex-start;
}

.form-input-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 1rem;
  color: #426b53;
  font-weight: 800;
  font-size: 25px;
  text-transform: uppercase;
}

label {
  margin-right: 0.5rem;
}

.signIn {
  border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #de854e;
  color: #f2ebe6;
  padding: 10px 70px;
  margin-top: 20px;
  font-weight: 800;
  font-size: 30px;
  text-transform: uppercase;
}

.userName {
  border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #f2ebe6;
  padding: 12.5px 100px 12.5px 50px;
  margin: 5px 0 60px 0;
  width: 100%;
}

.passWord {
  border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #f2ebe6;
  padding: 12.5px 100px 12.5px 50px;
  margin: 5px 0 20px 0;
  width: 100%;
}

.registervol {
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
}

.page-btn {
  font-weight: bold;
  color: #f2ebe6;
  text-decoration: none;
  font-weight: 800;
}

.regBtn {
  border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #de854e;
  color: #f2ebe6;
  padding: 10px 50px;
  margin-top: 20px;
  font-size: 30px;
  text-transform: uppercase;
  
}

#login {
  padding: 0%;
  margin: 0%;
  box-sizing: border-box;
  /* background-color: green; */
  display: flex;
  /* padding-left: 5%; */
  justify-content: space-between;
  align-items: center;
  height: 80vh;
}

h1{
  margin: 0 0 25px;
}

h2{
  color: #f2ebe6;
  margin-top: 100px;
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
</style>

