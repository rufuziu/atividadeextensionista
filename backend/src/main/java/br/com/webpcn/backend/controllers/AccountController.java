package br.com.webpcn.backend.controllers;

import br.com.webpcn.backend.dtos.UserDTO;
import br.com.webpcn.backend.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired
  UserService userService;

  @PostMapping("/register")
  public String registerAccount
          (@Valid @RequestBody UserDTO userDto){
    return userService.registerAccount(userDto);
  }

}
