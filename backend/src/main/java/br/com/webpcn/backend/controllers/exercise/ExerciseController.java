package br.com.webpcn.backend.controllers.exercise;

import br.com.webpcn.backend.dtos.exercise.ExerciseDTO;
import br.com.webpcn.backend.dtos.knowledgearea.KnowledgeAreaDTO;
import br.com.webpcn.backend.services.exercise.ExerciseService;
import br.com.webpcn.backend.services.knowledgearea.KnowledgeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
  @Autowired
  ExerciseService exerciseService;

  @GetMapping("/create")
  public ResponseEntity<Void> create(ExerciseDTO dto) {
    var val = exerciseService.create(dto);
    return val ?
            ResponseEntity.ok().build() :
            ResponseEntity.badRequest().build();
  }
}
