package com.antonio.MovieMarket.web.exception;

public record Error(
        String type,
        String message
) {
}
