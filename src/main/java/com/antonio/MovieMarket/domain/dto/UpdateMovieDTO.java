package com.antonio.MovieMarket.domain.dto;

import java.time.LocalDate;

public record UpdateMovieDTO(
        String title,
        LocalDate releaseDate,
        Double rating
) {
}
