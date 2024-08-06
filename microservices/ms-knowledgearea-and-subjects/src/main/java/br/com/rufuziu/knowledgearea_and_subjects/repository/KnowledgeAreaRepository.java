package br.com.rufuziu.knowledgearea_and_subjects.repository;

import br.com.rufuziu.knowledgearea_and_subjects.entity.KnowledgeArea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KnowledgeAreaRepository extends MongoRepository<KnowledgeArea,String> {
}
