package com.example.exerciciointegrador20.service;

import com.example.exerciciointegrador20.model.Movie;
import com.example.exerciciointegrador20.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService{
    private final MovieRepo repo;

    @Override
    public List<Movie> getAllMoviesByRatingFromActors(BigDecimal rating) {
        return repo.findAllByRatingActorsMost(rating);
    }

    @Override
    public List<Movie> getAllMoviesByGenre(Long genre_id) {
        return repo.findAllByGenre(genre_id);
    }
}
