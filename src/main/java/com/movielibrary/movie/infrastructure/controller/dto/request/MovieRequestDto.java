package com.movielibrary.movie.infrastructure.controller.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MovieRequestDto(
        @NotNull(message = "title must not be null")
        @NotEmpty(message = "title must not be empty")
        String title,
        @NotNull(message = "director must not be null")
        @NotEmpty(message = "director must not be empty")
        String director) {
}
