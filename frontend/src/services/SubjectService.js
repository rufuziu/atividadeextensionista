import axios from 'axios'

const SubjectApi = 'http://localhost:8081/api/'

const readAll = () => {
    return axios.get(SubjectApi + 'v1/subject/readAll')
}

const readByKnowledgeAreaId = (id) => {
    return axios.get(SubjectApi + 'v1/subject/readByKnowledgeArea/' + id)
}

export default { readAll, readByKnowledgeAreaId }

