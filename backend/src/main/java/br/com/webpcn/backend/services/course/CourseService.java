package br.com.webpcn.backend.services.course;

import br.com.webpcn.backend.dtos.course.CourseDTO;
import br.com.webpcn.backend.entities.course.Course;
import br.com.webpcn.backend.repositories.course.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  @Autowired
  CourseRepository courseRepository;
  @Autowired
  ModelMapper mapper;

  public Boolean create(CourseDTO dto) {
    var obj = courseRepository
            .save(mapper.map(dto, Course.class));
    return obj.getId() > 0;
  }
}