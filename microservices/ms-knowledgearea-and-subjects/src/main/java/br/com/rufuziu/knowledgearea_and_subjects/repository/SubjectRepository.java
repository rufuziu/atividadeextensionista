package br.com.rufuziu.knowledgearea_and_subjects.repository;

import br.com.rufuziu.knowledgearea_and_subjects.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubjectRepository extends MongoRepository<Subject, String> {
    List<Subject> findByKnowledgeAreaId(String knowledgeAreaId);
}
