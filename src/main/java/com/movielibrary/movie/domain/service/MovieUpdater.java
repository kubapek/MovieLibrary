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
public class MovieUpdater {
    private final MovieRetriever movieRetriever;
    private final MovieRepository movieRepository;
    public Movie updateMovieById(Long id, Movie newMovie) {
        movieRetriever.findById(id);
        log.info("Updating movie at index: " + id + " to " + newMovie.getTitle());
        return movieRepository.updateById(id, newMovie);
    }
}
