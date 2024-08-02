package br.com.rufuziu.knowledgearea_and_courses.repository;

import br.com.rufuziu.knowledgearea_and_courses.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject, String> {
}
