import axios from "axios";

export default {

    getAllPets() {
        return axios.get('/pets')
    },

    addNewPet(pet) {
        return axios.post('/pets/add', pet)
    },

    getPetByID(petID) {
        return axios.get(`/pets/${petID}`)
    },

    updatePet(pet) {
        return axios.put(`pets/${pet.petID}/update`, pet)
    }

}