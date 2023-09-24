package br.com.webpcn.backend.dtos;

import br.com.webpcn.backend.enums.ERole;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.validation.*;

public class UserDTO {
  public String fullName;
  @NotBlank(message = "Email cannot be empty.")
  public String email;
  @NotBlank(message = "Username cannot be empty.")
  public String username;
  @NotBlank(message = "Password cannot be empty.")
  public String password;
  public ERole role;
  public Boolean enabled;

  public UserDTO(String fullName, String email, String username, String password, ERole role, Boolean enabled) {
    this.fullName = fullName;
    this.email = email;
    this.username = username;
    this.password = password;
    this.role = role;
    this.enabled = enabled;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ERole getRole() {
    return role;
  }

  public void setRole(ERole role) {
    this.role = role;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }
}
