package com.example.exerciciointegrador19.repository;

import com.example.exerciciointegrador19.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepo extends JpaRepository<Serie, Integer> {
}
