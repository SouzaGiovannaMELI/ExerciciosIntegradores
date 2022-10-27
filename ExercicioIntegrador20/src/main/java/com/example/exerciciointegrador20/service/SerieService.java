package com.example.exerciciointegrador20.service;

import com.example.exerciciointegrador20.model.Series;
import com.example.exerciciointegrador20.repository.SerieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService implements ISerieService{
    private final SerieRepo repo;

    @Override
    public List<Series> getAllSeriesByNumberOfSeasons(int seasons) {
        return repo.findAllSeriesByNumberOfSeasons(seasons);
    }
}
