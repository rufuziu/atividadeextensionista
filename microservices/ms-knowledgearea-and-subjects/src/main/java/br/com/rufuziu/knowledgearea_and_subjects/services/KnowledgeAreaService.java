package br.com.rufuziu.knowledgearea_and_subjects.services;

import br.com.rufuziu.knowledgearea_and_subjects.dto.KnowledgeAreaDTO;
import br.com.rufuziu.knowledgearea_and_subjects.repository.KnowledgeAreaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KnowledgeAreaService {
    private final ModelMapper modelMapper;
    private final KnowledgeAreaRepository knowledgeAreaRepository;

    public KnowledgeAreaService(ModelMapper modelMapper, KnowledgeAreaRepository knowledgeAreaRepository) {
        this.modelMapper = modelMapper;
        this.knowledgeAreaRepository = knowledgeAreaRepository;
    }

    public List<KnowledgeAreaDTO> getAllKnowledgeAreas() {
        return knowledgeAreaRepository.findAll().stream()
                .map(knowledgeArea -> modelMapper.map(
                        knowledgeArea,
                        KnowledgeAreaDTO.class))
                .collect(Collectors.toList());
    }
}
