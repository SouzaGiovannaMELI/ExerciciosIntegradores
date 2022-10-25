package com.example.exerciciointegrador19.repository;

import com.example.exerciciointegrador19.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepo extends JpaRepository<Episode, Integer> {
}
