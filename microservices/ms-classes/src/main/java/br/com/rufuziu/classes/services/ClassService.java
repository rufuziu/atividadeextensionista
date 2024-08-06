package br.com.rufuziu.classes.services;

import br.com.rufuziu.classes.dto.ClassDTO;
import br.com.rufuziu.classes.repository.ClassRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService {
    private final ModelMapper modelMapper;
    private final ClassRepository classRepository;

    public ClassService(ModelMapper modelMapper, ClassRepository classRepository) {
        this.modelMapper = modelMapper;
        this.classRepository = classRepository;
    }

    public List<ClassDTO> getAllSubjects() {
        return classRepository.findAll().stream()
                .map(subject -> modelMapper.map(
                        subject,
                        ClassDTO.class))
                .collect(Collectors.toList());
    }
}
