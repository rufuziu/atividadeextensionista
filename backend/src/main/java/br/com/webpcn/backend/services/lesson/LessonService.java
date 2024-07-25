package br.com.webpcn.backend.services.lesson;

import br.com.webpcn.backend.dtos.lesson.LessonDTO;
import br.com.webpcn.backend.entities.lesson.Lesson;
import br.com.webpcn.backend.repositories.lesson.LessonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
  @Autowired
  LessonRepository lessonRepository;
  @Autowired
  ModelMapper mapper;

  public Boolean create(LessonDTO dto) {
    var obj = lessonRepository
            .save(mapper.map(dto, Lesson.class));
    return obj.getId() > 0;
  }
}