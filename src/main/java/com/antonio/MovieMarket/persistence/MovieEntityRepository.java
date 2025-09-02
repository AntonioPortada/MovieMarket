package com.antonio.MovieMarket.persistence;

import com.antonio.MovieMarket.domain.dto.MovieDTO;
import com.antonio.MovieMarket.domain.dto.UpdateMovieDTO;
import com.antonio.MovieMarket.domain.repository.MovieRepository;
import com.antonio.MovieMarket.persistence.crud.CrudMovieEntity;
import com.antonio.MovieMarket.persistence.entity.MovieEntity;
import com.antonio.MovieMarket.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    @Override
    public MovieDTO save(MovieDTO movieDTO) {
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDTO);
        movieEntity.setEstado("D");
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDTO update(long id, UpdateMovieDTO updateMovieDTO) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if(movieEntity == null) {
            return null;
        }

        //manual mapping
        /*movieEntity.setTitulo(updateMovieDTO.title());
        movieEntity.setFechaEstreno(updateMovieDTO.releaseDate());
        movieEntity.setClasificacion(BigDecimal.valueOf(updateMovieDTO.rating()));*/

        //mapstruct mapping
        this.movieMapper.updateEntityFromDto(updateMovieDTO, movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }
}
