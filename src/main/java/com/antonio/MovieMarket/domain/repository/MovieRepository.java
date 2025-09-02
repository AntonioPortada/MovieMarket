package com.antonio.MovieMarket.domain.repository;

import com.antonio.MovieMarket.domain.dto.MovieDTO;
import com.antonio.MovieMarket.domain.dto.UpdateMovieDTO;

import java.util.List;

public interface MovieRepository {

    List<MovieDTO> getAll();

    MovieDTO getById(long id);

    MovieDTO save(MovieDTO movieDTO);

    MovieDTO update(long id, UpdateMovieDTO updateMovieDTO);

    long delete(long id);
}
