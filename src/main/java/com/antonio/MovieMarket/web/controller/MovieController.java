package com.antonio.MovieMarket.web.controller;

import com.antonio.MovieMarket.domain.dto.MovieDTO;
import com.antonio.MovieMarket.domain.dto.SuggestRequestDTO;
import com.antonio.MovieMarket.domain.dto.UpdateMovieDTO;
import com.antonio.MovieMarket.domain.service.MovieMarketAiService;
import com.antonio.MovieMarket.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieMarketAiService movieMarketAiService;

    public MovieController(MovieService movieService, MovieMarketAiService movieMarketAiService) {
        this.movieService = movieService;
        this.movieMarketAiService = movieMarketAiService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>>  getAll() {
        List<MovieDTO> movies = this.movieService.getAll();

        if(movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getById(@PathVariable long id) {
        MovieDTO movieDTO = this.movieService.getById(id);

        if(movieDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDTO);
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMovieSuggestion(@RequestBody SuggestRequestDTO suggestRequestDTO) {
        return ResponseEntity.ok(this.movieMarketAiService.generateMovieSugestions(suggestRequestDTO.userPreference()));
    }

    @PostMapping
    public ResponseEntity<MovieDTO> add(@RequestBody MovieDTO movieDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.save(movieDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable long id, @RequestBody UpdateMovieDTO updateMovieDTO) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        return ResponseEntity.ok("Movie with id: "+ this.movieService.delete(id) +" was deleted");
    }
}
