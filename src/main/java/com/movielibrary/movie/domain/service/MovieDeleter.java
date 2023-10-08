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
public class MovieDeleter {
    private final MovieRepository movieRepository;
    private final MovieRetriever movieRetriever;

    public void deleteById(Long id) {
        Movie byId = movieRetriever.getMovieById(id);
        log.info("Deleting movie: " + byId.getTitle());
        movieRepository.deleteById(id);
    }
}
