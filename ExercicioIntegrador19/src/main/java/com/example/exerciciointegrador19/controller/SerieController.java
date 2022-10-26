package com.example.exerciciointegrador19.controller;

import com.example.exerciciointegrador19.model.Serie;
import com.example.exerciciointegrador19.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serie")
public class SerieController {
    @Autowired
    private ISerieService service;

    @PostMapping
    public ResponseEntity<Serie> save(@RequestBody Serie serie){
        return new ResponseEntity<>(service.insert(serie), HttpStatus.CREATED);
    }
}
