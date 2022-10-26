package com.example.exerciciointegrador22.controller;

import com.example.exerciciointegrador22.model.Funcionario;
import com.example.exerciciointegrador22.model.Produto;
import com.example.exerciciointegrador22.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private IProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        return new ResponseEntity<>(service.insert(produto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto produto){
        return new ResponseEntity<>(service.update(produto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
