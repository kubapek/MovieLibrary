package com.movielibrary.movie.domain.model;

public class MovieExistsException extends RuntimeException {
    public MovieExistsException(String message) {
        super(message);
    }
}
