package br.com.rufuziu.knowledgearea_and_courses.services;

import br.com.rufuziu.knowledgearea_and_courses.dto.user.UserDTO;
import br.com.rufuziu.knowledgearea_and_courses.dto.user.UserToActivateDTO;
import br.com.rufuziu.knowledgearea_and_courses.enums.ERole;
import br.com.rufuziu.knowledgearea_and_courses.exceptions.general.InvalidRequest;
import br.com.rufuziu.knowledgearea_and_courses.exceptions.user.UserAlreadyExists;
import br.com.rufuziu.knowledgearea_and_courses.repository.CourseRepository;
import br.com.rufuziu.knowledgearea_and_courses.repository.RoleRepository;
import br.com.rufuziu.knowledgearea_and_courses.repository.EducationLevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final CourseRepository adminRepository;
    private final EducationLevelRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(CourseRepository adminRepository,
                       EducationLevelRepository studentRepository,
                       TeacherRepository teacherRepository,
                       RoleRepository roleRepository,
                       ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public UserDTO createUser(UserDTO userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Optional<Role> roles = userDto.getRoles().stream().findFirst();
        if (roles.isPresent()) {
            Role role = roleRepository.findByName(roles.get().getName().name())
                    .orElseThrow(() -> new RuntimeException("Role not found"));

            userDto.getRoles().clear();
            userDto.getRoles().add(role);

            switch (role.getName()) {
                case ROLE_ADMIN:
                    if (adminRepository.existsByEmail(userDto.getEmail()))
                        throw new UserAlreadyExists(userDto.getEmail());
                    userDto.setActive(Boolean.TRUE);
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
        }
        return userDto;
    }

    public UserDTO activateUserByEmail(UserToActivateDTO userToActivateDto) {
        ERole role = userToActivateDto.getRoles().stream().findFirst().get().getName();
        UserDTO userDto  = new UserDTO();
        switch (role) {
            case ROLE_STUDENT:
                if (studentRepository.existsByEmailAndActiveFalse(userToActivateDto.getEmail())) {
                    Optional<Student> student = studentRepository.findByEmail(userToActivateDto.getEmail());
                    student.get().setActive(Boolean.TRUE);
                    userDto = modelMapper.map(studentRepository.save(student.get()), UserDTO.class);
                } else {
                    throw new InvalidRequest("Invalid request. IP registered.");
                }
                break;
            case ROLE_TEACHER:
                if (teacherRepository.existsByEmailAndActiveFalse(userToActivateDto.getEmail())) {
                    Optional<Teacher> teacher = teacherRepository.findByEmail(userToActivateDto.getEmail());
                    teacher.get().setActive(Boolean.TRUE);
                    userDto = modelMapper.map(teacherRepository.save(teacher.get()), UserDTO.class);
                } else {
                    throw new InvalidRequest("Invalid request. IP registered.");
                }
                break;
        }
    return userDto;
    }
}
