package com.antonio.MovieMarket.web.exception;

import com.antonio.MovieMarket.domain.exception.MovieAlreadyExistsException;
import com.antonio.MovieMarket.domain.exception.MovieDoesNotExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> movieAlreadyExists(MovieAlreadyExistsException ex) {
        Error error = new Error(MovieAlreadyExistsException.class.toString(), ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieDoesNotExistsException.class)
    public ResponseEntity<Error> movieDoesNotExist(MovieDoesNotExistsException ex) {
        Error error = new Error(MovieDoesNotExistsException.class.getSimpleName(), ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
