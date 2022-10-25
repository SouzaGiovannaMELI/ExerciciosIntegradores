package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Serie;
import com.example.exerciciointegrador19.repository.SerieRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SerieService implements ISerieService{
    private SerieRepo repo;

    @Override
    public Serie insert(Serie movie) {
        return repo.save(movie);
    }

    @Override
    public List<Serie> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
