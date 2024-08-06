import axios from 'axios'

const AuthApi = 'http://localhost:8080/api/'

const authUser = (user) => {
    return axios.post(AuthApi + 'v1/auth', user)
        .then(response => {
            console.log(response)
        })
        .catch(error => {
            console.error(error)
        })
}

export default { authUser }

