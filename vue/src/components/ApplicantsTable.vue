<template>
  <div class="applicants-table">
    <h1>Pending Volunteers</h1>
    <table>
      <thead>
        <th>Date Added</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>phone</th>
        <th>email</th>
        <th>Accept</th>
        <th>Decline</th>
      </thead>
      <tbody>
        <tr v-for="applicant in applicants" v-bind:key="applicant.applicantId">
          <td class="left date">{{ applicant.date }}</td>
          <td class="left fname">{{ applicant.firstName }}</td>
          <td class="left lname">{{ applicant.lastName }}</td>
          <td class="left phone">{{ applicant.phoneNum }}</td>
          <td class="left email">{{ applicant.email }}</td>
          <td class="has-icon"><i class="fa-solid fa-square-check"></i></td>
          <td class="has-icon"><i class="fa-solid fa-square-xmark"></i></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ApplicantService from "../services/ApplicantService";

export default {
  data() {
    return {
      applicants: [],
    };
  },
  created() {
    ApplicantService.getApplicants().then((response) => {
      this.applicants = response.data;
    });
  },
};
</script>

<style scoped>
.applicants-table {
  margin: 0 50px;
}

h1 {
  font-size: 50px;
  margin: 50px 0 0px 240px;
}

table {
  margin: 0 auto;
  background-color: #335137;
  border-collapse: collapse;
  border-radius: 50px;
  border-bottom-left-radius: 50px;
}

th {
  color: #f2ebe6;
  padding: 20px 30px 15px 30px;
  font-size: 15px;
  text-transform: uppercase;
  text-align: left;
  border-radius: 50px;
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

tr:last-child td:first-child {
  border-bottom-left-radius: 50px;
}

tr:last-child td:last-child {
  border-bottom-right-radius: 50px;
}

td {
  border: none;
  padding: 15px 0px;
}

td.left {
  padding-left: 30px;
}

td.has-icon {
  text-align: center;
  padding: 0 20px;
}

td i.fa-solid {
  color: #3d7b51;
  font-size: 25px;
}

td i.fa-square-xmark {
  color: #d32f2f;
}
</style>
