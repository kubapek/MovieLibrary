package com.movielibrary.movie.infrastructure.controller.error;

import org.springframework.http.HttpStatus;

public record MovieRestControllerErrorHandlerResponse(String message, HttpStatus status) {
}
