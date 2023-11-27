package br.com.webpcn.backend.exceptions.usertorole;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR)
public class UserToRoleException extends RuntimeException {
  public UserToRoleException(String message) {
    super(message);
  }
}
