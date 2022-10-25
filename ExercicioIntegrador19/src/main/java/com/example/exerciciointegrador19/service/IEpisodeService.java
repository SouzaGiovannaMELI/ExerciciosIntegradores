package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Episode;

import java.util.List;

public interface IEpisodeService {
    Episode insert(Episode episode);
    List<Episode> getAll();
    void delete(int id);
}
