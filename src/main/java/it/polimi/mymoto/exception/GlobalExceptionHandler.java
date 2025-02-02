package it.polimi.mymoto.exception;


import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.exception.custom.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @ExceptionHandler(EntityRegistrationException.class)
    public ResponseEntity<CustomResponse> handleEntityRegistrationException(EntityRegistrationException e) {
        return ResponseEntity.badRequest().body(new CustomResponse(e.getMessage()));
    }

    @ExceptionHandler(EntityModifyException.class)
    public ResponseEntity<CustomResponse> handleEntityModifyException(EntityModifyException e) {
        return ResponseEntity.badRequest().body(new CustomResponse(e.getMessage()));
    }

    @ExceptionHandler(EntityDeleteException.class)
    public ResponseEntity<CustomResponse> handleEntityDeleteException(EntityDeleteException e) {
        return ResponseEntity.badRequest().body(new CustomResponse(e.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomResponse> handleNotFoundException(EntityNotFoundException e) {
        CustomResponse response = new CustomResponse(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
