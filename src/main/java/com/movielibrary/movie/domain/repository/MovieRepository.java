package com.movielibrary.movie.domain.repository;

import com.movielibrary.movie.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Modifying
    @Query("UPDATE Movie m SET m.title = :#{#newMovie.title}, m.director = :#{#newMovie.director} WHERE m.id = :id")
    void updateById(Long id, Movie newMovie);
    Movie findByTitle(String title);
    boolean existsByTitleAndDirector(String title, String director);
}
