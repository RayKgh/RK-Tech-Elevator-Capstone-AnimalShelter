<template>
  <div id="update-psw">
    <form @submit.prevent="submit">
      <h1>Welcome to the Team!</h1>
      <h2>Please change your password.</h2>

      <div id="password-box">
        <label for="psw">New Password</label>
        <input
          v-model="newPassword"
          type="password"
          id="psw"
          name="psw"
          required
        />
        <label for="confirm-psw">Confirm Password</label>
        <input
          v-model="confirmPassword"
          type="password"
          id="confirm-psw"
          name="confirm-psw"
          required
        />
      </div>
      <div role="alert" v-if="submitError" class="error-msg">
        Unable to submit password changes. Please try again later.
      </div>

      <div role="alert" v-if="passwordsNotMatched" class="error-msg">
        Passwords did not match. Please try again.
      </div>
      <button type="submit" class="update-psw-btn">Submit</button>
    </form>
  </div>
</template>

<script>
import AuthService from "../services/AuthService";
export default {
  name: "update-password",
  data() {
    return {
      newPassword: "",
      confirmPassword: "",
      passwordsNotMatched: false,
      submitError: false,
    };
  },
  methods: {
    submit() {
      if (this.newPassword !== this.confirmPassword) {
        this.passwordsNotMatched = true;
      } else {
        AuthService.updatePassword(this.newPassword)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({ name: "home" });
            }
          })
          .catch((error) => {
            const response = error.response;

            if (response.status === 400) {
              this.submitError = true;
              console.log("jake");
            }
          });
      }
    },
  },
};
</script>

<style scoped>
#update-psw {
  padding: 0%;
  margin: 0%;
  box-sizing: border-box;
  height: 80vh;
}

h1 {
  margin: 0 0 25px;
}

h2 {
  color: #59351f;
  margin-top: 0px;
  margin-left: 10px;
  font-size: 25px;
  margin-bottom: 20px;
}

form {
  display: flex;
  flex-direction: column;
  /* background-color: aliceblue; */
  height: 70vh;
  margin-left: 5%;
  align-self: flex-start;
  margin-top: 50px;
  align-items: flex-start;
}

#password-box {
  display: flex;
  flex-direction: column;
  margin-bottom: 1rem;
  color: #426b53;
  font-weight: 800;
  font-size: 20px;
  text-transform: uppercase;
  width: 500px;
}

label {
  margin-left: 40px;
}

.update-psw-btn {
  border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #de854e;
  color: #f2ebe6;
  padding: 10px 50px;
  margin-top: -10px;
  font-weight: 800;
  font-size: 30px;
  text-transform: uppercase;
}

input {
  border-radius: 50px;
  border: 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  background-color: #f2ebe6;
  padding: 10px;
  margin: 5px 0px 50px 0px;
  width: 80%;
  font-size: 25px;
  color: #59351f;
  font-weight: 600;
}

input:focus,
select:focus,
textarea:focus,
button:focus {
  outline: none;
}
</style>
