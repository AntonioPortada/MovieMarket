package com.antonio.MovieMarket.web.exception;

import com.antonio.MovieMarket.domain.exception.MovieAlreadyExistsException;
import com.antonio.MovieMarket.domain.exception.MovieDoesNotExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handlerException(MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.add(new Error(error.getField(), error.getDefaultMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    //Catch generic errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handlerException(Exception ex) {
        Error error = new Error("unknown-error", ex.getMessage());
        ex.printStackTrace();
        return ResponseEntity.internalServerError().body(error);
    }
}
