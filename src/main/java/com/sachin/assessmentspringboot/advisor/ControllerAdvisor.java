package com.sachin.assessmentspringboot.advisor;

import com.sachin.assessmentspringboot.exception.DuplicateException;
import com.sachin.assessmentspringboot.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdvisor {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<StandardResponse<String>> handleConstraintViolationException(DuplicateException e) {
        return new ResponseEntity<>(
                new StandardResponse<>(
                        "04", e.getMessage(), null
                ),
                HttpStatus.BAD_REQUEST);
    }
}
