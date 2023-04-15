<template>
  <div>
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
            v-bind:petID="pet.petID"
            ><i class="fa-solid fa-pen-to-square"></i
          ></router-link>
        </td>
      </tr>
    </tbody>
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
    
<style>
</style>