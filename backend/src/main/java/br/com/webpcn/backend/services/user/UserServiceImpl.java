package br.com.webpcn.backend.services.user;

import br.com.webpcn.backend.entities.Role;
import br.com.webpcn.backend.entities.User;
import br.com.webpcn.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{
  @Autowired
  UserRepository userRepository;
  @Override
  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException
              ("Invalid username or password.");
    }
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
