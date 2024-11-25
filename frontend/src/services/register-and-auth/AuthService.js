import axios from 'axios'
import ms from '../../configs/microservices.js'

const authUser = (user) => { return axios.post(ms.register_and_auth.concat('v1/auth'), user) }

export default { authUser }

