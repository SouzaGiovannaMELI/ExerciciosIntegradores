package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Genre;

import java.util.List;

public interface IGenreService {
    Genre insert(Genre genre);
    List<Genre> getAll();
    void delete(int id);
}
