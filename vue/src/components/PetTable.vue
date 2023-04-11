<template>
  <div>
      <thead>
          <th>Name</th>
          <th>Date Added</th>
          <th>Status</th>
          <th>Update</th>
      </thead>
      <tbody>
          <tr v-for="pet in pets" v-bind:key="pet.id">
              <td>{{pet.name}}</td>
              <td>{{pet.dateAdded}}</td>
              <td>{{pet.status}}</td>
              <td><i class="fa-solid fa-pen-to-square"></i></td>
          </tr>
      </tbody>
  </div>
</template>

<script>
export default {
name: "pet-table",
    data() {
        return{
            pets: [
            {
                id: 1,
                name: "Rocky",
                dateAdded: "12-12-22",
                status: "Available",
            },
        ]
        }
        
    }
}
</script>
    
<style>

</style>