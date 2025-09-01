package com.antonio.MovieMarket.domain.dto;

import com.antonio.MovieMarket.domain.Genre;

import java.time.LocalDate;

public record MovieDTO(
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        Boolean status
) {
}
