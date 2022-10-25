package com.example.exerciciointegrador19.repository;

import com.example.exerciciointegrador19.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepo extends JpaRepository<Season, Integer> {
}
