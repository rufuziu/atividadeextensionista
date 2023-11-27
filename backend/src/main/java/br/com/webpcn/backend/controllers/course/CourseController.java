package br.com.webpcn.backend.controllers.course;

import br.com.webpcn.backend.dtos.course.CourseDTO;
import br.com.webpcn.backend.services.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
  @Autowired
  CourseService courseService;

  @GetMapping("/create")
  public ResponseEntity<Void> create(CourseDTO dto) {
    var val = courseService.create(dto);
    return val ?
            ResponseEntity.ok().build() :
            ResponseEntity.badRequest().build();
  }
}
