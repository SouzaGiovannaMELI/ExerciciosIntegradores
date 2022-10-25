package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Season;
import com.example.exerciciointegrador19.repository.SeasonRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SeasonService implements ISeasonService{
    private SeasonRepo repo;

    @Override
    public Season insert(Season movie) {
        return repo.save(movie);
    }

    @Override
    public List<Season> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
