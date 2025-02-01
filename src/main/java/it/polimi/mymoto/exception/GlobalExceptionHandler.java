package it.polimi.mymoto.exception;


import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.exception.custom.DataValidationException;
import it.polimi.mymoto.exception.custom.UserNotFoundException;
import it.polimi.mymoto.exception.custom.UserRegistrationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * This class is used to handle all the exceptions that are thrown in the application.
 */
@RestControllerAdvice // This annotation is used to handle exceptions thrown by the controllers.
public class GlobalExceptionHandler {
    @ExceptionHandler(DataValidationException.class)
    public ResponseEntity<HashMap<String,  Object>> handleDataValidationException(DataValidationException e) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String validationMessages = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .reduce("", (acc, message) -> acc + message + ", ");
        return ResponseEntity.badRequest().body(new CustomResponse(validationMessages));
    }

    @ExceptionHandler({
            UserNotFoundException.class,
            UserRegistrationException.class
    })
    public ResponseEntity<CustomResponse> handleUserNotFoundException(RuntimeException e) {
        return ResponseEntity.badRequest().body(new CustomResponse(e.getMessage()));
    }
}
