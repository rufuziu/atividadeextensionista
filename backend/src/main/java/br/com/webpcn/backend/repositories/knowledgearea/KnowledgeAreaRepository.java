package br.com.webpcn.backend.repositories.knowledgearea;

import br.com.webpcn.backend.entities.knowledgearea.KnowledgeArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeAreaRepository extends JpaRepository<KnowledgeArea, Integer> {
}
