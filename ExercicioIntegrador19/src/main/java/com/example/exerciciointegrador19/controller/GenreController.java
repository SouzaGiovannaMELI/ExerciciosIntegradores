package com.example.exerciciointegrador19.controller;

import com.example.exerciciointegrador19.model.Genre;
import com.example.exerciciointegrador19.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private IGenreService service;

    @PostMapping
    public ResponseEntity<Genre> save(@RequestBody Genre genre){
        return new ResponseEntity<>(service.insert(genre), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
