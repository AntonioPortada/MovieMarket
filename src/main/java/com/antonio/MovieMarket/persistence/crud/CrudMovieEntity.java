package com.antonio.MovieMarket.persistence.crud;

import com.antonio.MovieMarket.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {
}
