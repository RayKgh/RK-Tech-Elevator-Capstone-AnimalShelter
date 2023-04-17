<template>
  <div>
    <h1>Directory</h1>
    <user-table />
  </div>
</template>

<script>
import UserTable from "../components/UserTable.vue";

export default {
  components: { UserTable },
  name: "directory",
};
</script>

<style scoped>
h1 {
  font-size: 50px;
  width: 60%;
  margin: 0 auto;
}
</style>
