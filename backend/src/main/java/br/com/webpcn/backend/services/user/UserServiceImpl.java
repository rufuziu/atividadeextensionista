package br.com.webpcn.backend.services.user;

import br.com.webpcn.backend.dtos.UserDTO;
import br.com.webpcn.backend.entities.Role;
import br.com.webpcn.backend.entities.User;
import br.com.webpcn.backend.exceptions.user.UserNotCreatedException;
import br.com.webpcn.backend.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{
  @Autowired
  ModelMapper modelMapper;
  @Autowired
  UserRepository userRepository;
  @Override
  public User findByUsername(String username) {
  Optional<User> user = userRepository.findByUsername(username);
  if(user.isEmpty())
    throw new UserNotCreatedException("User not created.");
  else return user.get();
  }

  @Override
  public String registerAccount(UserDTO userDTO) {
    User userSaved =
            userRepository.save(
                    modelMapper.map(userDTO,User.class));
    if(userSaved==null)
      throw new UserNotCreatedException("User not created.");
    return "User created. Confirm the email that we have sent.";
  }

  @Override
  public UserDetails loadUserByUsername(
//          String email
          String username
  ){
//    User user = userRepository.findByEmail(email);
    User user = findByUsername(username);
    return new org.springframework.security.core.userdetails.User
            (user.getUsername(), user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
  }

  private Collection<? extends GrantedAuthority> mapRolesToAuthorities
          (Collection<Role> roles) {
    return roles.stream().map(role -> new SimpleGrantedAuthority
            (role.getUserRole().name())).collect(Collectors.toList());
  }
}
