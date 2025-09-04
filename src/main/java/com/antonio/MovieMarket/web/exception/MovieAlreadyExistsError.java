package com.antonio.MovieMarket.web.exception;

public record MovieAlreadyExistsError(
        String type,
        String message
) {
}
