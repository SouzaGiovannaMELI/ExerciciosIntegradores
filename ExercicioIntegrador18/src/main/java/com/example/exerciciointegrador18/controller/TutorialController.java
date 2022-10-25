package com.example.exerciciointegrador18.controller;

import com.example.exerciciointegrador18.model.Tutorial;
import com.example.exerciciointegrador18.service.ITutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {
    @Autowired
    private ITutorialService service;

    @PostMapping
    public ResponseEntity<Tutorial> save(@RequestBody Tutorial tutorial){
        return new ResponseEntity<>(service.save(tutorial), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/by_id/{id}")
    public ResponseEntity<Tutorial> getById(@PathVariable long id){
        Optional<Tutorial> tutorial = service.getById(id);

        if(tutorial.isPresent())
            return ResponseEntity.ok(tutorial.get());

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/by_id/{id}")
    public ResponseEntity<Tutorial> updateById(@PathVariable long id, @RequestBody Tutorial tutorial){
        return ResponseEntity.ok(service.updateById(id, tutorial));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping("/by_id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id){
        service.deleteById(id);
    }

    @GetMapping("/published")
    public ResponseEntity<List<Tutorial>> getAllPublished(){
        return ResponseEntity.ok(service.getAllPublished());
    }

    @GetMapping("/by")
    public ResponseEntity<List<Tutorial>> getAllByTitle(@RequestParam String title){
        return ResponseEntity.ok(service.getAllByTitle(title));
    }

    @PatchMapping("/by_id/{id}/published")
    public ResponseEntity<Tutorial> updateStatusPublished(@PathVariable long id){
        return ResponseEntity.ok(service.updateStatusPublished(id));
    }
}
