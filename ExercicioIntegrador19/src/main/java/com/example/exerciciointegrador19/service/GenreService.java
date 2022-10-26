package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Genre;
import com.example.exerciciointegrador19.repository.GenreRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService implements IGenreService{
    private GenreRepo repo;

    @Override
    public Genre insert(Genre genre) {
        return repo.save(genre);
    }

    @Override
    public List<Genre> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
