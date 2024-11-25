package br.com.rufuziu.ms_register_and_auth.exceptions.general;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class InvalidRequest extends RuntimeException {
        public InvalidRequest(String message) {
            super(message);
        }
}
