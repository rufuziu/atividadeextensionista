package br.com.webpcn.backend.services.user;

import br.com.webpcn.backend.dtos.user.UserDTO;

public interface UserService{
  public UserDTO registerAccount(UserDTO userDTO);
}