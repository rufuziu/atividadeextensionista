package br.com.rufuziu.knowledgearea_and_courses.repository;

import br.com.rufuziu.knowledgearea_and_courses.entity.KnowledgeArea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KnowledgeAreaRepository extends MongoRepository<KnowledgeArea,String> {
}
