package com.example.exerciciointegrador20.service;

import com.example.exerciciointegrador20.model.Episode;

import java.util.List;

public interface IEpisodeService {
    List<Episode> getAllEpisodesByActor(Long actor_id);
}
