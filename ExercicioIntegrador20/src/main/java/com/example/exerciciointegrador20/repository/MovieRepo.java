package com.example.exerciciointegrador20.repository;

import com.example.exerciciointegrador20.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m where m.id in (select am.movie.id from ActorMovie am where am.actor.rating > :rating)")
    List<Movie> findAllByRatingActorsMost(BigDecimal rating);
    @Query("select m from Movie m where m.genre.id = :genre_id")
    List<Movie> findAllByGenre(Long genre_id);
}
