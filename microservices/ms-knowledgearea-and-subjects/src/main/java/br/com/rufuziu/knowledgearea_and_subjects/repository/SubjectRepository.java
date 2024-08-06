package br.com.rufuziu.knowledgearea_and_subjects.repository;

import br.com.rufuziu.knowledgearea_and_subjects.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject, String> {
}
