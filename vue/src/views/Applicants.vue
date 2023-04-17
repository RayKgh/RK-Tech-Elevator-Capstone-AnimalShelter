<template>
  <div class="applicants">
    <applicants-table />
  </div>
</template>

<script>
import ApplicantsTable from "../components/ApplicantsTable.vue";
export default {
  name: "applicants",
  components: {
    ApplicantsTable,
  },
};
</script>

<style scoped></style>
