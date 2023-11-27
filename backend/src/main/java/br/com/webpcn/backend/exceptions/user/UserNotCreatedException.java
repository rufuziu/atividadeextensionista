package br.com.webpcn.backend.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR)
public class UserNotCreatedException extends RuntimeException {
  public UserNotCreatedException(String message) {
    super(message);
  }
}
