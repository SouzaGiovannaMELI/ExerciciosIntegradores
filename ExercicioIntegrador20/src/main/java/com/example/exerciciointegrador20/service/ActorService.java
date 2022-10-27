package com.example.exerciciointegrador20.service;

import com.example.exerciciointegrador20.model.Actor;
import com.example.exerciciointegrador20.repository.ActorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService implements IActorService{
    private final ActorRepo repo;

    @Override
    public List<Actor> getAllActorsContainsFavoriteMovie() {
        return repo.findAllByFavoriteMovieIsNotNull();
    }

    @Override
    public List<Actor> getAllActorsRatingMost(BigDecimal rating) {
        return repo.findAllByRatingIsAfter(rating);
    }

    @Override
    public List<Actor> getAllByWorkingInMovie(Long movie_id) {
        return repo.findAllByWorkingInMovie(movie_id);
    }
}
