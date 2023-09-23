package br.com.webpcn.backend.repositories;

import br.com.webpcn.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
  User findByEmail(String email);
}
