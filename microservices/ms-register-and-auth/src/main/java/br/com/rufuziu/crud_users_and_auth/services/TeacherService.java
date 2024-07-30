package br.com.rufuziu.crud_users_and_auth.services;

import br.com.rufuziu.crud_users_and_auth.dto.user.UserDTO;
import br.com.rufuziu.crud_users_and_auth.entity.Teacher;
import br.com.rufuziu.crud_users_and_auth.entity.User;
import br.com.rufuziu.crud_users_and_auth.exceptions.general.InvalidRequest;
import br.com.rufuziu.crud_users_and_auth.exceptions.user.UserAlreadyExists;
import br.com.rufuziu.crud_users_and_auth.exceptions.user.UserNotFound;
import br.com.rufuziu.crud_users_and_auth.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository repository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public TeacherService(TeacherRepository repository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }
}
