package com.movielibrary.movie.infrastructure.controller;

import com.movielibrary.movie.domain.model.Movie;
import com.movielibrary.movie.infrastructure.controller.dto.request.MovieRequestDto;
import com.movielibrary.movie.infrastructure.controller.dto.response.MovieDto;

public class MovieMapper {
    public static MovieDto mapToDto(Movie movie) {
        return new MovieDto(movie.getId(), movie.getTitle(), movie.getDirector());
    }

    public static Movie mapFromRequestToMovie(MovieRequestDto movie) {
        return new Movie(movie.title(), movie.director());
    }
}
