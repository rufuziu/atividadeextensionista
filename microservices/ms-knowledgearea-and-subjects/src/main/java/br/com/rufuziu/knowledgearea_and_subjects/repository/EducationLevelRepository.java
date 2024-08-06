package br.com.rufuziu.knowledgearea_and_subjects.repository;

import br.com.rufuziu.knowledgearea_and_subjects.entity.EducationLevel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EducationLevelRepository extends MongoRepository<EducationLevel, String> {
}
