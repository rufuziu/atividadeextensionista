package br.com.webpcn.backend.controllers.user;

import br.com.webpcn.backend.dtos.user.UserDTO;
import br.com.webpcn.backend.services.user.UserServiceImpl;
import br.com.webpcn.backend.services.usertorole.UserToRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired
  UserServiceImpl userServiceImpl;
  @Autowired
  UserToRoleService userToRoleService;

  @PostMapping("/register")
  public ResponseEntity<String> registerAccount
          (@Valid @RequestBody UserDTO userDto){
    UserDTO userRegistered = userServiceImpl.registerAccount(userDto);

    if(userToRoleService.bindUserToRole(userRegistered) != null)
      return ResponseEntity
              .ok("User registered with success. Confirm your email.");
    else return null;
  }

}
