package com.antonio.MovieMarket.domain.exception;

public class MovieDoesNotExistsException extends RuntimeException {

    public MovieDoesNotExistsException(String movieTitle) {
        super("La película "+ movieTitle +" no existe.");
    }

    public MovieDoesNotExistsException(long id) {
        super("La película con id: "+ id +" no existe.");
    }
}
