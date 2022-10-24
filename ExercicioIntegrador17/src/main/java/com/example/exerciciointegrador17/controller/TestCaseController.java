package com.example.exerciciointegrador17.controller;

import com.example.exerciciointegrador17.model.TestCase;
import com.example.exerciciointegrador17.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private TestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<TestCase> save(@RequestBody TestCase test){
        return new ResponseEntity<>(service.insert(test), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getById(@PathVariable long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> updateById(@PathVariable long id, @RequestBody TestCase test){
        return new ResponseEntity<>(service.updateById(id, test), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id){
        service.delete(id);
    }

    @GetMapping("/by")
    public ResponseEntity<List<TestCase>> getAllByLastUpdate(@RequestParam String last_update){
        return new ResponseEntity<>(service.getAllByLastUpdate(LocalDate.parse(last_update)), HttpStatus.OK);
    }
}
