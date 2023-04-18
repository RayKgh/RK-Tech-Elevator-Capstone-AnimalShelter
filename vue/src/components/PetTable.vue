<template>
  <div>
    <table>
      <thead>
        <th>Name</th>
        <th>Date Added</th>
        <th>Status</th>
        <th>Update</th>
      </thead>
      <tbody>
        <tr v-for="pet in pets" v-bind:key="pet.petID">
          <td>{{ pet.petName }}</td>
          <td v-if="pet.entryDate">{{ pet.entryDate }}</td>
          <td v-else>No Entry Date Listed</td>
          <td>{{ pet.adoptionStatus }}</td>
          <td>
            <router-link
              :to="{ name: 'update-pet', params: { petID: pet.petID } }"
              ><i class="fa-solid fa-pen-to-square"></i
            ></router-link>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "pet-table",
  computed: {
    pets() {
      return this.$store.state.pets;
    },
  },
};
</script>
    

<style scoped>
h1 {
  font-size: 50px;
  text-align: center;
  margin-right: 20vw;
}

table {
  margin: 0 auto;
  background-color: #335137;
  border-collapse: collapse;
  border-radius: 30px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
  width: 1200px;
}

th {
  color: #f2ebe6;
  padding: 20px 30px 15px 30px;
  font-size: 15px;
  text-transform: uppercase;
  text-align: left;
  border-radius: 30px;
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
  border-bottom-left-radius: 30px;
}

tr:last-child td:last-child {
  border-bottom-right-radius: 30px;
}

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
