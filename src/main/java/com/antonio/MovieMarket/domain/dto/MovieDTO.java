package com.antonio.MovieMarket.domain.dto;

import com.antonio.MovieMarket.domain.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record MovieDTO(

        @NotBlank(message = "El título no debe ser blanco")
        @Min(value = 3, message = "Título mayor a 3 carácteres")
        String title,

        @Min(value = 50, message = "La duración debe ser mayor a 50 min")
        Integer duration,

        @NotNull(message = "Se debe mandar el genre")
        Genre genre,

        @PastOrPresent(message = "La fecha debe ser menor al día de hoy")
        @NotNull(message = "Debes proporcionar una fecha")
        LocalDate releaseDate,

        @Min(value = 0, message = "El rating debe ser mayor a 0")
        @Max(value = 5, message = "El rating debe ser menos a 5")
        Double rating,

        @NotNull(message = "Se necesita el estado")
        Boolean status
) {
}
