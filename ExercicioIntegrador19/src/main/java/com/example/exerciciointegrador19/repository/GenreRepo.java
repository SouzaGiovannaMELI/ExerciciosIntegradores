package com.example.exerciciointegrador19.repository;

import com.example.exerciciointegrador19.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Integer> {
}
