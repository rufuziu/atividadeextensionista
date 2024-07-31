package br.com.rufuziu.knowledgearea_and_courses.security.services;

import br.com.rufuziu.knowledgearea_and_courses.exceptions.user.UserNotFound;
import br.com.rufuziu.knowledgearea_and_courses.repository.CourseRepository;
import br.com.rufuziu.knowledgearea_and_courses.repository.EducationLevelRepository;
import br.com.rufuziu.knowledgearea_and_courses.security.dto.UserDetailsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ModelMapper modelMapper;

    public UserDetailsServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public UserDetailsImpl loadUserByUsername(String email) {
        User user = findUser(email);
        return UserDetailsImpl.build(user);
    }
}
