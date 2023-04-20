import http from "axios";

export default {

    getAllPetPhotos() {
        return http.get(`/photos`);
    }

}