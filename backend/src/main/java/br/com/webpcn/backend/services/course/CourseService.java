package br.com.webpcn.backend.services.course;

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
}
