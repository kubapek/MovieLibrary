package com.movielibrary.movie.infrastructure.controller.error;

import com.movielibrary.movie.domain.model.MovieExistsException;
import com.movielibrary.movie.domain.model.MovieNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class MovieRestControllerErrorHandler {

    @ExceptionHandler
    public ResponseEntity<MovieRestControllerErrorHandlerResponse> handleMovieNotFound(MovieNotFoundException exception) {
        log.warn("MovieNotFoundException while accesing movie");
        MovieRestControllerErrorHandlerResponse response = new MovieRestControllerErrorHandlerResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(MovieExistsException.class)
    public ResponseEntity<MovieRestControllerErrorHandlerResponse> handleMovieAlreadyExists(MovieExistsException exception) {
        log.warn("MovieExistsException while adding movie");
        MovieRestControllerErrorHandlerResponse response = new MovieRestControllerErrorHandlerResponse(exception.getMessage(), HttpStatus.CONFLICT);
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

}
