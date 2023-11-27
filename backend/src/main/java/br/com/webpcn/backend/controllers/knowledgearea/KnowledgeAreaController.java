package br.com.webpcn.backend.controllers.knowledgearea;

import br.com.webpcn.backend.dtos.knowledgearea.KnowledgeAreaDTO;
import br.com.webpcn.backend.services.knowledgearea.KnowledgeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/knowledgearea")
public class KnowledgeAreaController {
  @Autowired
  KnowledgeAreaService knowledgeAreaService;

  @GetMapping("/create")
  public ResponseEntity<Void> create(KnowledgeAreaDTO dto) {
    var val = knowledgeAreaService.create(dto);
    return val ?
            ResponseEntity.ok().build() :
            ResponseEntity.badRequest().build();
  }
}
