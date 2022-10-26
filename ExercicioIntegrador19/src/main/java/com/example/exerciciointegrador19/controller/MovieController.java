package com.example.exerciciointegrador19.controller;

import com.example.exerciciointegrador19.model.Movie;
import com.example.exerciciointegrador19.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private IMovieService service;

    @PostMapping
    public ResponseEntity<Movie> save(@RequestBody Movie movie){
        return new ResponseEntity<>(service.insert(movie), HttpStatus.CREATED);
    }
}
