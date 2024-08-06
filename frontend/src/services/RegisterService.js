import axios from 'axios'

const RegisterApi = 'http://localhost:8080/api/'

const registerUser = (user) => {
    return axios.post(RegisterApi + 'v1/register', user)
}

export default { registerUser }

