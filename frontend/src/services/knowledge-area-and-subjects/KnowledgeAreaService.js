import axios from 'axios'
import ms from '../../configs/microservices.js'


const readAll = () => {
    return axios.get(ms.knowledgearea_and_subjects.concat('v1/knowledge-area/readAll'))
}
const readByEducationLevelId = (id) => {
    return axios.get(ms.knowledgearea_and_subjects.concat('v1/knowledge-area/readByEducationLevel/' + id))
}

export default { readAll, readByEducationLevelId }

