<template>
  <div class="applicants-table">
    <h1>Pending Volunteers</h1>
    <div class="border"></div>
    <div class="table">
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
          <tr
            v-for="applicant in applicants"
            v-bind:key="applicant.applicantId"
          >
            <td class="left date">{{ applicant.date }}</td>
            <td class="left fname">{{ applicant.firstName }}</td>
            <td class="left lname">{{ applicant.lastName }}</td>
            <td class="left phone">{{ applicant.phoneNum }}</td>
            <td class="left email">{{ applicant.email }}</td>
            <td
              class="has-icon"
              @click="approveApplicant(applicant, 'approved')"
            >
              <i class="fa-solid fa-square-check"></i>
            </td>
            <td
              class="has-icon"
              @click="approveApplicant(applicant, 'declined')"
            >
              <i class="fa-solid fa-square-xmark"></i>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <div role="alert" v-if="submitError" class="submit-error">
      There was an error processing your request. Please try again later.
    </div>
  </div>
</template>

<script>
import ApplicantService from "../services/ApplicantService";

export default {
  data() {
    return {
      applicants: [],
      submitError: false,
    };
  },
  created() {
    ApplicantService.getApplicants().then((response) => {
      this.applicants = response.data;
    });
  },
  methods: {
    approveApplicant(applicant, status) {
      applicant.status = status;
      ApplicantService.updateApplicantStatus(applicant)
        .then((response) => {
          if (response.status == 201) {
            this.applicants = this.applicants.filter(
              (a) => a.applicationId != applicant.applicationId
            );
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 400) {
            this.submitError = true;
            applicant.status = "pending";
          }
        });
    },
  },
};
</script>

<style scoped>
.applicants-table {
  margin: 50px;
}

h1 {
  font-size: 50px;
  text-align: center;
  margin-right: 20vw;
}

.border {
  background-color: red;
  z-index: 1;
  width: 100px;
}

table {
  margin: 0 auto;
  background-color: #335137;
  border-collapse: collapse;
  /* border-radius: 30px; */
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  z-index: 0;
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
  border-radius: 30px;
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
