<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1>Login Here!</h1>
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
      </div>
      <div class="form-input-group">
        <label for="password" >Password</label>
        <input type="password" id="password" v-model="user.password" required class="passWord"/>
      </div>
      <button type="submit" class="signIn">Sign in</button>
      <p>
        <router-link :to="{ name: 'register' }"
          >Need an account? Sign up.</router-link
        >
      </p>
    </form>
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
            this.$router.push("/");
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
h1{
  color: #426b53;
}

.form-input-group {
  margin-bottom: 1rem;
  color: #426b53;
}
label {
  margin-right: 0.5rem;
}

.signIn {
  border-radius: 16px;
  background-color: #de854e;
  color: white;
  padding: 15px 50px;
  font-weight: bold;
  font-family: "Poppins", sans-serif;
}

.userName{
  border-radius: 16px;
  background-color: #D1CDC7;
  padding: 15px 50px;
}

.passWord{
  border-radius: 16px;
  background-color: #D1CDC7;
  padding: 15px 50px;
}


</style>