import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getApplicants() {
        return http.get('/applicants')
    },

    updateApplicantStatus(applicant) {
        return http.put('/applicant', applicant)
    },
}