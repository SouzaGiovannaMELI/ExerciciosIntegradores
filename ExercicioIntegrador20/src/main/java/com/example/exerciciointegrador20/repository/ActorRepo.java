package com.example.exerciciointegrador20.repository;

import com.example.exerciciointegrador20.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ActorRepo extends JpaRepository<Actor, Long> {
    List<Actor> findAllByFavoriteMovieIsNotNull();
    List<Actor> findAllByRatingIsAfter(BigDecimal rating);
    @Query("select a from Actor a where a.id in (select am.actor from ActorMovie am where am.movie.id = :movie_id)")
    List<Actor> findAllByWorkingInMovie(Long movie_id);
}
