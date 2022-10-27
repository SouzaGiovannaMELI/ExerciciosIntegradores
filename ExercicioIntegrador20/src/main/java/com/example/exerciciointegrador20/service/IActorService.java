package com.example.exerciciointegrador20.service;

import com.example.exerciciointegrador20.model.Actor;

import java.math.BigDecimal;
import java.util.List;

public interface IActorService {
    List<Actor> getAllActorsContainsFavoriteMovie();

    List<Actor> getAllActorsRatingMost(BigDecimal rating);

    List<Actor> getAllByWorkingInMovie(Long movie_id);
}
