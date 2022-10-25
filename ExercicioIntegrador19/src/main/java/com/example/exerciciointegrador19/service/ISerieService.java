package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Serie;

import java.util.List;

public interface ISerieService {
    Serie insert(Serie movie);
    List<Serie> getAll();
    void delete(int id);
}
