package br.com.rufuziu.knowledgearea_and_courses.exceptions;

import br.com.rufuziu.knowledgearea_and_courses.exceptions.error.ErrorDetails;
import br.com.rufuziu.knowledgearea_and_courses.exceptions.general.InvalidRequest;
import br.com.rufuziu.knowledgearea_and_courses.exceptions.user.UserAlreadyExists;
import br.com.rufuziu.knowledgearea_and_courses.exceptions.user.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(
            Exception ex,
            WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(InvalidRequest.class)
    public final ResponseEntity<ErrorDetails> handleInvalidRequestException(
            Exception ex,
            WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserAlreadyExists.class)
    public final ResponseEntity<ErrorDetails> handleUserAlreadyExistsException(
            Exception ex,
            WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UserNotFound.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(
            Exception ex,
            WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
