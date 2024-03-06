package com.sachin.assessmentspringboot.advisor;

import com.sachin.assessmentspringboot.exception.DuplicateException;
import com.sachin.assessmentspringboot.exception.InValidCredentials;
import com.sachin.assessmentspringboot.exception.NotFoundException;
import com.sachin.assessmentspringboot.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<StandardResponse<String>> handleDuplicateException(DuplicateException e) {
        return new ResponseEntity<>(
                new StandardResponse<>(
                        "04", e.getMessage(), null
                ),
                HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<StandardResponse<String>> handleHttpMediaTypeNotSupportedException(
            HttpMediaTypeNotSupportedException ex) {
        StandardResponse<String> badRequest = new StandardResponse<>("06", "Bad Request", null);
        return new ResponseEntity<>(badRequest, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse<String>> handleNotFoundException(
            NotFoundException ex) {
        StandardResponse<String> badRequest = new StandardResponse<>("02", ex.getMessage(), null);
        return new ResponseEntity<>(badRequest, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<StandardResponse<String>> handleBadCredentialsException(
            BadCredentialsException ex) {
        StandardResponse<String> badRequest = new StandardResponse<>("03", "Invalid Credentials", null);
        return new ResponseEntity<>(badRequest, HttpStatus.UNAUTHORIZED);
    }
}
