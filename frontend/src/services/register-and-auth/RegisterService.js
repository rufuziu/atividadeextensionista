import axios from 'axios'
import ms from '../../configs/microservices.js'

const registerUser = (user) => {
    return axios.post(ms.register_and_auth.concat('v1/register'), user)
}

export default { registerUser }

