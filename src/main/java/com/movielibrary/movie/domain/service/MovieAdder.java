package com.movielibrary.movie.domain.service;

import com.movielibrary.movie.domain.model.Movie;
import com.movielibrary.movie.domain.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
@Log4j2
@AllArgsConstructor
@Service
@Transactional
public class MovieAdder {
    private final MovieRepository movieRepository;
    public Movie addMovie(Movie movie) {
        Movie existingMovie = movieRepository.findByTitle(movie.getTitle());

        if (existingMovie == null || !existingMovie.getDirector().equals(movie.getDirector())) {
            log.info("adding new movie:" + movie.getTitle());
            return movieRepository.save(movie);
        } else {
            throw new IllegalStateException("This movie already exists");
        }
    }
}
