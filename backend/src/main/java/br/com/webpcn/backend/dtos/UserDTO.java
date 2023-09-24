package br.com.webpcn.backend.dtos;

import br.com.webpcn.backend.enums.ERole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.validation.*;

public class UserDTO {
  public Long id;
  public String fullName;
  @NotBlank(message = "Email cannot be empty")
  @Email(message = "Must be a valid email")
  @Size(max = 128, message = "Email maximum size is 128")
  public String email;
  @NotBlank(message = "Username cannot be empty")
  @Size(min= 6,max = 16,
          message = "Username size is 6 - 16")
  public String username;
  @NotBlank(message = "Password cannot be empty")
  @Size(min= 6,max = 16,
          message = "Password size is 6 - 16")
  public String password;

  @NotBlank(message = "Password cannot be empty")
  @Size(min= 6,max = 16,
          message = "Confirm password size is 6 - 16")
  public String confirmPassword;
  public ERole role;
  public Integer roleId;
  public Boolean enabled;

  public UserDTO(String fullName,
                 String email,
                 String username,
                 String password,
                 String confirmPassword,
                 ERole role,
                 Integer roleId,
                 Boolean enabled) {
    this.fullName = fullName;
    this.email = email;
    this.username = username;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.role = role;
    this.roleId = roleId;
    this.enabled = enabled;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
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

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }
}
