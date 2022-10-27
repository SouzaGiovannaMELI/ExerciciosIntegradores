package com.example.exerciciointegrador20.repository;

import com.example.exerciciointegrador20.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SerieRepo extends JpaRepository<Series, Long> {
    @Query("select s from Series s where s.seasons.size > :seasons")
    List<Series> findAllSeriesByNumberOfSeasons(int seasons);
}
