package br.com.rufuziu.exercises.exceptions.general;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class InvalidRequest extends RuntimeException {
        public InvalidRequest(String message) {
            super(message);
        }
}
