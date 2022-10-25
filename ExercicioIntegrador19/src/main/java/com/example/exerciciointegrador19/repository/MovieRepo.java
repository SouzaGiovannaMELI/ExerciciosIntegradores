package com.example.exerciciointegrador19.repository;

import com.example.exerciciointegrador19.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
}
