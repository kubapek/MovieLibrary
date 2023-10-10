package com.movielibrary.movie.infrastructure.controller;

import com.movielibrary.movie.domain.model.Movie;
import com.movielibrary.movie.domain.service.MovieRetriever;
import com.movielibrary.movie.infrastructure.controller.dto.response.MovieDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/movies-view") // Nowy endpoint dla widoku
public class MovieViewController {
    private final MovieRetriever movieRetriever;

    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> allMovies = movieRetriever.getAll();
        List<MovieDto> allMoviesDto = allMovies.stream()
                .map(MovieMapper::mapToDto)
                .toList();
        model.addAttribute("movies", allMoviesDto);
        return "movieList";
    }
}
