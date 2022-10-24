package com.example.exerciciointegrador16.controller;

import com.example.exerciciointegrador16.model.Joia;
import com.example.exerciciointegrador16.service.IJoia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class JoiaController {
    @Autowired
    private IJoia service;

    @PostMapping("/joia/inserir")
    public ResponseEntity<String> save(@RequestBody Joia joia){
        return new ResponseEntity<>("número de identificação: " +service.save(joia), HttpStatus.CREATED);
    }

    @GetMapping("/joias")
    public ResponseEntity<List<Joia>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/joia/excluir")
    public ResponseEntity<Void> delete(@RequestParam long numero_identificacao){
        service.delete(numero_identificacao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/joia/atualizar")
    public ResponseEntity<Joia> update(@RequestParam long numero_identificacao, @RequestBody Joia joia){
        return new ResponseEntity<>(service.update(numero_identificacao, joia), HttpStatus.OK);
    }
}
