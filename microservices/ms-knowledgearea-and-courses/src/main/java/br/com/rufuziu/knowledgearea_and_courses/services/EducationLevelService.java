package br.com.rufuziu.knowledgearea_and_courses.services;

import br.com.rufuziu.knowledgearea_and_courses.dto.EducationLevelDTO;
import br.com.rufuziu.knowledgearea_and_courses.entity.EducationLevel;
import br.com.rufuziu.knowledgearea_and_courses.repository.EducationLevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationLevelService {
    private final ModelMapper modelMapper;
    private final EducationLevelRepository educationLevelRepository;

    public EducationLevelService(ModelMapper modelMapper, EducationLevelRepository educationLevelRepository) {
        this.modelMapper = modelMapper;
        this.educationLevelRepository = educationLevelRepository;
    }

    public List<EducationLevelDTO> getAllEducationLevels(){
        return educationLevelRepository.findAll().stream()
                .map(educationLevel -> modelMapper.map(
                        educationLevel,
                        EducationLevelDTO.class))
                .collect(Collectors.toList());
    }
}
