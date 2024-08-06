package br.com.rufuziu.exercises.services;

import br.com.rufuziu.exercises.dto.ExerciseDTO;
import br.com.rufuziu.exercises.repository.ExerciseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {
    private final ModelMapper modelMapper;
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ModelMapper modelMapper, ExerciseRepository exerciseRepository) {
        this.modelMapper = modelMapper;
        this.exerciseRepository = exerciseRepository;
    }

    public List<ExerciseDTO> getAllSubjects() {
        return exerciseRepository.findAll().stream()
                .map(subject -> modelMapper.map(
                        subject,
                        ExerciseDTO.class))
                .collect(Collectors.toList());
    }
}
