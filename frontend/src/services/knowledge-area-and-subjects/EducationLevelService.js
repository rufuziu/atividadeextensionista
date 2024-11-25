import axios from 'axios'

import ms from '../../configs/microservices.js'

const readAll = () => {
    return axios.get(ms.knowledgearea_and_subjects.concat('v1/education-level/readAll'))
}

export default { readAll }

