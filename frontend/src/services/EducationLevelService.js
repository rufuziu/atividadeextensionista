import axios from 'axios'

const EducationLevelApi = 'http://localhost:8081/api/'

const readAll = () => {
    return axios.get(EducationLevelApi + 'v1/education-level/readAll')
}

export default { readAll }

