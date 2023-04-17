<template>
  <div>
    <table>
      <thead>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Role</th>
      </thead>
      <tbody>
        <tr v-for="user in users" v-bind:key="user.userId">
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.email }}</td>
          <td>{{ user.phone }}</td>
          <td>{{ user.authorities[0] }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import AuthService from "../services/AuthService";
export default {
  data() {
    return {
      users: [],
    };
  },
  created() {
    AuthService.getUserList().then((response) => {
      this.users = response.data;
    });
  },
};
</script>

<style>
</style>