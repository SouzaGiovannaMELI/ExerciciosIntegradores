package com.example.exerciciointegrador19.controller;

import com.example.exerciciointegrador19.model.Actor;
import com.example.exerciciointegrador19.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private IActorService service;

    @PostMapping
    public ResponseEntity<Actor> save(@RequestBody Actor actor){
        return new ResponseEntity<>(service.insert(actor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Actor>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
