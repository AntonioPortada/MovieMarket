package com.antonio.MovieMarket.web.exception;

import com.antonio.MovieMarket.domain.exception.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<MovieAlreadyExistsError> movieAlreadyExists(MovieAlreadyExistsException ex) {
        MovieAlreadyExistsError error = new MovieAlreadyExistsError(MovieAlreadyExistsException.class.toString(), ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
