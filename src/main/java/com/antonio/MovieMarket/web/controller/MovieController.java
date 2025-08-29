package com.antonio.MovieMarket.web.controller;

import com.antonio.MovieMarket.domain.dto.MovieDTO;
import com.antonio.MovieMarket.domain.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<MovieDTO>  getAll() {
        return this.movieService.getAll();
    }
}
