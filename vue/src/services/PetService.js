import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllPets() {
        return http.get('/pets')
    },

    addNewPet(pet) {
        return http.post('/pets/add', pet)
    }

}