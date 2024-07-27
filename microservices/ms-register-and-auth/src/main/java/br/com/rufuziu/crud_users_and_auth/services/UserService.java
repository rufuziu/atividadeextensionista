package br.com.rufuziu.crud_users_and_auth.services;

import br.com.rufuziu.crud_users_and_auth.dto.user.UserDTO;
import br.com.rufuziu.crud_users_and_auth.entity.Admin;
import br.com.rufuziu.crud_users_and_auth.entity.Student;
import br.com.rufuziu.crud_users_and_auth.entity.Teacher;
import br.com.rufuziu.crud_users_and_auth.entity.User;
import br.com.rufuziu.crud_users_and_auth.exceptions.user.UserAlreadyExists;
import br.com.rufuziu.crud_users_and_auth.exceptions.user.UserNotFound;
import br.com.rufuziu.crud_users_and_auth.repository.AdminRepository;
import br.com.rufuziu.crud_users_and_auth.repository.StudentRepository;
import br.com.rufuziu.crud_users_and_auth.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(AdminRepository adminRepository,
                       StudentRepository studentRepository,
                       TeacherRepository teacherRepository,
                       ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public UserDTO createUser(UserDTO userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        switch (userDto.getRole()) {
            case ROLE_ADMIN:
                if (adminRepository.existsByEmail(userDto.getEmail()))
                    throw new UserAlreadyExists(userDto.getEmail());
                Admin admin = adminRepository.save(modelMapper.map(userDto, Admin.class));
                userDto = modelMapper.map(admin, UserDTO.class);
                break;
            case ROLE_STUDENT:
                if (studentRepository.existsByEmail(userDto.getEmail()))
                    throw new UserAlreadyExists(userDto.getEmail());
                Student student = studentRepository.save(modelMapper.map(userDto, Student.class));
                userDto = modelMapper.map(student, UserDTO.class);
                break;
            case ROLE_TEACHER:
                if (teacherRepository.existsByEmail(userDto.getEmail()))
                    throw new UserAlreadyExists(userDto.getEmail());
                Teacher teacher = teacherRepository.save(modelMapper.map(userDto, Teacher.class));
                userDto = modelMapper.map(teacher, UserDTO.class);
                break;
        }
        return userDto;
    }
}
