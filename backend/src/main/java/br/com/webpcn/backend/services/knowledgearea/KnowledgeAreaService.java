package br.com.webpcn.backend.services.knowledgearea;

import br.com.webpcn.backend.repositories.knowledgearea.KnowledgeAreaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeAreaService {
  @Autowired
  KnowledgeAreaRepository knowledgeAreaRepository;
  @Autowired
  ModelMapper mapper;
}
