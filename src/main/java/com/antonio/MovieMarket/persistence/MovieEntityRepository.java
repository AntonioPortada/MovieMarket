package com.antonio.MovieMarket.persistence;

import com.antonio.MovieMarket.domain.dto.MovieDTO;
import com.antonio.MovieMarket.domain.repository.MovieRepository;
import com.antonio.MovieMarket.persistence.crud.CrudMovieEntity;
import com.antonio.MovieMarket.persistence.entity.MovieEntity;
import com.antonio.MovieMarket.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDTO> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDTO getById(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }
}
