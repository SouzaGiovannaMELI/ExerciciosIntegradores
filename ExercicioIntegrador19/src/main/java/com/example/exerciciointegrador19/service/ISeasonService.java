package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Season;

import java.util.List;

public interface ISeasonService {
    Season insert(Season movie);
    List<Season> getAll();
    void delete(int id);
}
