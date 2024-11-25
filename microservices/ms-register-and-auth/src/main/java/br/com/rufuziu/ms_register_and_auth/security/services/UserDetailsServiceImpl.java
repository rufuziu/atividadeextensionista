package br.com.rufuziu.ms_register_and_auth.security.services;

import br.com.rufuziu.ms_register_and_auth.entity.Admin;
import br.com.rufuziu.ms_register_and_auth.entity.Student;
import br.com.rufuziu.ms_register_and_auth.entity.Teacher;
import br.com.rufuziu.ms_register_and_auth.entity.User;
import br.com.rufuziu.ms_register_and_auth.enums.ERole;
import br.com.rufuziu.ms_register_and_auth.exceptions.user.UserNotFound;
import br.com.rufuziu.ms_register_and_auth.repository.AdminRepository;
import br.com.rufuziu.ms_register_and_auth.repository.StudentRepository;
import br.com.rufuziu.ms_register_and_auth.repository.TeacherRepository;
import br.com.rufuziu.ms_register_and_auth.security.dto.UserDetailsImpl;
import br.com.rufuziu.ms_register_and_auth.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    public UserDetailsServiceImpl(AdminRepository adminRepository,
                                  StudentRepository studentRepository,
                                  TeacherRepository teacherRepository,
                                  ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
    }

    public User findUser(String email) {
        if (adminRepository.existsByEmail(email)) {
            return modelMapper.map(
                    adminRepository.findByEmail(email).get(), User.class);
        } else if (teacherRepository.existsByEmail(email)) {
            return modelMapper.map(
                    teacherRepository.findByEmail(email).get(), User.class);
        } else if (studentRepository.existsByEmail(email)) {
            return modelMapper.map(
                    studentRepository.findByEmail(email).get(), User.class);
        } else throw new UserNotFound("User not found!");
    }


    @Override
    public UserDetailsImpl loadUserByUsername(String email) {
        User user = findUser(email);
        return UserDetailsImpl.build(user);
    }
}
