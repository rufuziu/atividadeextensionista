package br.com.rufuziu.knowledgearea_and_subjects.services;

import br.com.rufuziu.knowledgearea_and_subjects.dto.SubjectDTO;
import br.com.rufuziu.knowledgearea_and_subjects.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    private final ModelMapper modelMapper;
    private final SubjectRepository subjectRepository;

    public SubjectService(ModelMapper modelMapper, SubjectRepository subjectRepository) {
        this.modelMapper = modelMapper;
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectDTO> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(subject -> modelMapper.map(
                        subject,
                        SubjectDTO.class))
                .collect(Collectors.toList());
    }
}