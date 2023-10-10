package com.movielibrary.movie.infrastructure.controller;

import com.movielibrary.movie.domain.model.Movie;
import com.movielibrary.movie.domain.service.MovieAdder;
import com.movielibrary.movie.domain.service.MovieDeleter;
import com.movielibrary.movie.domain.service.MovieRetriever;
import com.movielibrary.movie.domain.service.MovieUpdater;
import com.movielibrary.movie.infrastructure.controller.dto.request.MovieRequestDto;
import com.movielibrary.movie.infrastructure.controller.dto.response.MovieDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.movielibrary.movie.infrastructure.controller.MovieMapper.mapFromRequestToMovie;
import static com.movielibrary.movie.infrastructure.controller.MovieMapper.mapToDto;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieRestController {
    private final MovieAdder movieAdder;
    private final MovieRetriever movieRetriever;
    private final MovieUpdater movieUpdater;
    private final MovieDeleter movieDeleter;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<Movie> allMovies = movieRetriever.getAll();
        List<MovieDto> allMoviesDto = allMovies.stream()
                .map(MovieMapper::mapToDto)
                .toList();
        return ResponseEntity.ok(allMoviesDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id) {
        Movie movieById = movieRetriever.getMovieById(id);
        MovieDto movieByIdDto = mapToDto(movieById);
        return ResponseEntity.ok(movieByIdDto);
    }

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody @Valid MovieRequestDto createMovie) {
        Movie movie = mapFromRequestToMovie(createMovie);
        Movie savedMovie = movieAdder.addMovie(movie);
        MovieDto movieDto = mapToDto(savedMovie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMovieById(@PathVariable Long id,
                                                    @RequestBody @Valid MovieRequestDto updateMovie) {
        Movie movie = mapFromRequestToMovie(updateMovie);
        movieUpdater.updateMovieById(id, movie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        movieDeleter.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
