package com.antonio.MovieMarket.persistence.mapper;

import com.antonio.MovieMarket.domain.dto.MovieDTO;
import com.antonio.MovieMarket.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, StatusMapper.class})
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "stringToGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")
    @Mapping(source = "estado", target = "status", qualifiedByName = "stringToBoolean")
    MovieDTO toDto(MovieEntity entity);
    List<MovieDTO> toDto(Iterable<MovieEntity> enetities);

    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genero", qualifiedByName = "genreToString")
    @Mapping(source = "status", target = "estado", qualifiedByName = "booleanToString")
    MovieEntity toEntity(MovieDTO dto);
}
