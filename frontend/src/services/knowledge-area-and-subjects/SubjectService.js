import axios from 'axios'
import ms from '../../configs/microservices.js'

const readAll = () => {
    return axios.get(ms.knowledgearea_and_subjects.concat('v1/subject/readAll'))
}

const readByKnowledgeAreaId = (id) => {
    return axios.get(ms.knowledgearea_and_subjects.concat('v1/subject/readByKnowledgeArea/' + id))
}

export default { readAll, readByKnowledgeAreaId }

