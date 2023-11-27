package br.com.webpcn.backend.controllers.lesson;

import br.com.webpcn.backend.dtos.lesson.LessonDTO;
import br.com.webpcn.backend.services.lesson.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson")
public class LessonController {
  @Autowired
  LessonService lessonService;

  @GetMapping("/create")
  public ResponseEntity<Void> create(LessonDTO dto) {
    var val = lessonService.create(dto);
    return val ?
            ResponseEntity.ok().build() :
            ResponseEntity.badRequest().build();
  }
}
