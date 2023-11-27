package br.com.webpcn.backend.services.user;

import br.com.webpcn.backend.dtos.UserDTO;
import br.com.webpcn.backend.entities.user.User;
import br.com.webpcn.backend.exceptions.user.UserNotCreatedException;
import br.com.webpcn.backend.repositories.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
  @Autowired
  UserRepository userRepository;
  @Autowired
  ModelMapper modelMapper;
  @Autowired
  PasswordEncoder passwordEncoder;
  @Override
  public UserDTO registerAccount(UserDTO userDTO) {
    if (userDTO.password.equals(userDTO.confirmPassword)) {
      userDTO.setPassword(
              passwordEncoder.encode(
                      userDTO.getPassword()));
      User userSaved =
              userRepository.save(
                      modelMapper.map(userDTO, User.class));
      if (userSaved == null)
        throw new UserNotCreatedException("User not created.");
      else {
        userDTO.setId(userSaved.getId());
        return userDTO;
      }
    }
    else
      throw new UserNotCreatedException("Passwords don't matches");
  }
}
