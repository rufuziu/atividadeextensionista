package br.com.webpcn.backend.entities;

import br.com.webpcn.backend.enums.ERole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private ERole userRole;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ERole getUserRole() {
    return userRole;
  }

  public void setUserRole(ERole userRole) {
    this.userRole = userRole;
  }
}
