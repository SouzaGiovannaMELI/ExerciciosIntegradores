package com.example.exerciciointegrador20.service;

import com.example.exerciciointegrador20.model.Movie;

import java.math.BigDecimal;
import java.util.List;

public interface IMovieService {
    List<Movie> getAllMoviesByRatingFromActors(BigDecimal rating);

    List<Movie> getAllMoviesByGenre(Long genre_id);
}
