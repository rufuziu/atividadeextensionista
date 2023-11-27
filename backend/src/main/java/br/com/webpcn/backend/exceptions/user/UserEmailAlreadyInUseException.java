package br.com.webpcn.backend.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class UserEmailAlreadyInUseException extends RuntimeException {
  public UserEmailAlreadyInUseException(String message) {
    super(message);
  }
}
