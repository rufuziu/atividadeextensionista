package br.com.webpcn.backend.dtos;

import br.com.webpcn.backend.enums.ERole;

public class UserToRoleDTO {
  private Long userId;
  private Integer role;

  public UserToRoleDTO(Long userId, Integer role) {
    this.userId = userId;
    this.role = role;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Integer getRoleId() {
    return role;
  }

  public void setRoleId(Integer role) {
    this.role = role;
  }
}
