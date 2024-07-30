package br.com.rufuziu.crud_users_and_auth.services;

import br.com.rufuziu.crud_users_and_auth.dto.user.UserDTO;
import br.com.rufuziu.crud_users_and_auth.entity.Admin;
import br.com.rufuziu.crud_users_and_auth.exceptions.general.InvalidRequest;
import br.com.rufuziu.crud_users_and_auth.exceptions.user.UserAlreadyExists;
import br.com.rufuziu.crud_users_and_auth.exceptions.user.UserNotFound;
import br.com.rufuziu.crud_users_and_auth.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository repository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository repository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO createUser(UserDTO userDto) {
        if (repository.existsByEmail(userDto.getEmail())) throw new UserAlreadyExists(userDto.getEmail());

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Admin admin = repository.save(modelMapper.map(userDto, Admin.class));

        return modelMapper.map(admin,UserDTO.class);
    }



    public UserDTO readUser(String email) {
        Optional<Admin> user = repository.findByEmail(email);

        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDTO.class);
        } else throw new UserNotFound("User not found!");
    }

    public UserDTO updateUser(UserDTO userDTO, String email) {
        if (userDTO.getEmail().contains(email)) {
            Optional<Admin> user = repository.findByEmail(email);
            if (user.isPresent()) {
                user.get().updateUser(userDTO);
                repository.save(user.get());
                return modelMapper.map(user.get(), UserDTO.class);
            } else {
                String message = new StringBuilder()
                        .append("User with email: ")
                        .append(userDTO.getEmail())
                        .append(" not found")
                        .toString();
                throw new UserNotFound(message);
            }
        } else throw new InvalidRequest("The emails don't match!");
    }

    public String deleteUser() {
        return null;
    }
}
