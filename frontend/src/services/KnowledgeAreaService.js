import axios from 'axios'

const KnowledgeAreaApi = 'http://localhost:8081/api/'

const readAll = () => {
    return axios.get(KnowledgeAreaApi + 'v1/knowledge-area/readAll')
}
const readByEducationLevelId = (id) => {
    return axios.get(KnowledgeAreaApi + 'v1/knowledge-area/readByEducationLevel/' + id)
}

export default { readAll, readByEducationLevelId }

