package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Movie;

import java.util.List;

public interface IMovieService {
    Movie insert(Movie movie);
    List<Movie> getAll();
    void delete(int id);
}
