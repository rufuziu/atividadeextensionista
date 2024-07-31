package br.com.rufuziu.knowledgearea_and_courses.repository;

import br.com.rufuziu.knowledgearea_and_courses.entity.EducationLevel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EducationLevelRepository extends MongoRepository<EducationLevel, String> {
}
