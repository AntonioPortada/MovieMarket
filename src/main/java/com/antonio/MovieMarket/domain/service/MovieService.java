package com.antonio.MovieMarket.domain.service;

import com.antonio.MovieMarket.domain.dto.MovieDTO;
import com.antonio.MovieMarket.domain.dto.UpdateMovieDTO;
import com.antonio.MovieMarket.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las películas que existan dentro de la plataforma")
    public List<MovieDTO> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDTO getById(long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDTO save(MovieDTO movieDTO) {
        return this.movieRepository.save(movieDTO);
    }

    public MovieDTO update(long id, UpdateMovieDTO updateMovieDTO) {
        return this.movieRepository.update(id, updateMovieDTO);
    }

    public long delete(long id) {
        return this.movieRepository.delete(id);
    }
}
