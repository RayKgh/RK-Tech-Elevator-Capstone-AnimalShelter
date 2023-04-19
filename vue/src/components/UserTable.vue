<template>
  <div>
    <table>
      <thead>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone Number</th>
      </thead>
      <tbody>
        <tr v-for="user in users" v-bind:key="user.userId">
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.email }}</td>
          <td>{{ user.phone }}</td>
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

<style scoped>
table {
  margin: 0 auto;
  background-color: #335137;
  border-collapse: collapse;
  /* border-radius: 30px; */
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  width: 1200px;
}

th {
  color: #f2ebe6;
  padding: 20px 30px 15px 30px;
  font-size: 15px;
  text-transform: uppercase;
  text-align: left;
  /* border-radius: 30px; */
}

tr {
  color: #335137;
}

tr:nth-child(even) {
  background-color: #e1dbd6;
}
tr:nth-child(odd) {
  background-color: #f2ebe6;
}

/* tr:last-child td:first-child {
  border-bottom-left-radius: 30px;
}

tr:last-child td:last-child {
  border-bottom-right-radius: 30px;
} */

td {
  border: none;
  padding: 15px 0px;
  padding-left: 25px;
}

td.left {
  padding-left: 30px;
}

td.has-icon {
  text-align: center;
}

td i.fa-solid {
  padding-left: 20px;
  color: #3d7b51;
  font-size: 25px;
}
</style>
