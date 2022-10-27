package com.example.exerciciointegrador20.service;

import com.example.exerciciointegrador20.model.Series;

import java.util.List;

public interface ISerieService {
    List<Series> getAllSeriesByNumberOfSeasons(int seasons);
}
