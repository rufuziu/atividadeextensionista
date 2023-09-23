package br.com.webpcn.backend.services.user;

import br.com.webpcn.backend.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  public User findByUsername(String username);
}
