import http from 'axios';



export default {
    getApplicants() {
        return http.get('/applicants')
    },

    updateApplicantStatus(applicant) {
        return http.put('/applicant', applicant)
    },
}