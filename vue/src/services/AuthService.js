import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  updatePassword(newPassword) {
    return axios.put('/newpassword', {newPassword})
  },

  getUserList(){
    return axios.get('/userlist')
  }

  // adopt() {
  //   return axios.post('/adopt', )
  // },







}
