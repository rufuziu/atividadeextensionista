import axios from 'axios'

const AuthApi = 'http://localhost:8080/api/'

const authUser = (user) => { return axios.post(AuthApi + 'v1/auth', user) }

export default { authUser }

