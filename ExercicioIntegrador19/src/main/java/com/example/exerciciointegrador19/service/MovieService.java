package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Movie;
import com.example.exerciciointegrador19.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService{
    private final MovieRepo repo;

    @Override
    public Movie insert(Movie movie) {
        return repo.save(movie);
    }

    @Override
    public List<Movie> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
