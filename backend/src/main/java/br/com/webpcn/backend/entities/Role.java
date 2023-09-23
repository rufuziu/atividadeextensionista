package br.com.webpcn.backend.entities;

import br.com.webpcn.backend.enums.ERole;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "roles")
public class Role {
  @Id
  private Long id;
  private Long userId;
  private ERole userRole;
}
