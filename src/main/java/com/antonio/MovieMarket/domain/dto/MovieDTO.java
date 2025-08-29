package com.antonio.MovieMarket.domain.dto;

import java.time.LocalDate;

public record MovieDTO(
        String title,
        Integer duration,
        String genre,
        LocalDate releaseDate,
        Double rating
) {
}
