package br.com.webpcn.backend.services.exercise;

import br.com.webpcn.backend.repositories.exercise.ExerciseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
  @Autowired
  ExerciseRepository exerciseRepository;
  @Autowired
  ModelMapper mapper;
}
