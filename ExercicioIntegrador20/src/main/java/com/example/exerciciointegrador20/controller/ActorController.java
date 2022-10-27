package com.example.exerciciointegrador20.controller;

import com.example.exerciciointegrador20.model.*;
import com.example.exerciciointegrador20.service.IActorService;
import com.example.exerciciointegrador20.service.IEpisodeService;
import com.example.exerciciointegrador20.service.IMovieService;
import com.example.exerciciointegrador20.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private IActorService service;

    @Autowired
    private IMovieService serviceMovie;

    @Autowired
    private ISerieService serviceSerie;

    @Autowired
    private IEpisodeService serviceEpisode;

    @GetMapping("/item-1")
    public ResponseEntity<List<Actor>> item1(){
        return ResponseEntity.ok(service.getAllActorsContainsFavoriteMovie());
    }

    @GetMapping("/item-2/{rating}")
    public ResponseEntity<List<Actor>> item2(@PathVariable BigDecimal rating){
        return ResponseEntity.ok(service.getAllActorsRatingMost(rating));
    }

    @GetMapping("/item-3/{movie_id}")
    public ResponseEntity<List<Actor>> item3(@PathVariable Long movie_id){
        return ResponseEntity.ok(service.getAllByWorkingInMovie(movie_id));
    }

    @GetMapping("/item-4/{rating}")
    public ResponseEntity<List<Movie>> item4(@PathVariable BigDecimal rating){
        return ResponseEntity.ok(serviceMovie.getAllMoviesByRatingFromActors(rating));
    }

    @GetMapping("/item-5/{genre_id}")
    public ResponseEntity<List<Movie>> item5(@PathVariable Long genre_id){
        return ResponseEntity.ok(serviceMovie.getAllMoviesByGenre(genre_id));
    }

    @GetMapping("/item-6/{seasons}")
    public ResponseEntity<List<Series>> item6(@PathVariable int seasons){
        return ResponseEntity.ok(serviceSerie.getAllSeriesByNumberOfSeasons(seasons));
    }

    @GetMapping("/item-7/{actor_id}")
    public ResponseEntity<List<Episode>> item7(@PathVariable Long actor_id){
        return ResponseEntity.ok(serviceEpisode.getAllEpisodesByActor(actor_id));
    }
}
