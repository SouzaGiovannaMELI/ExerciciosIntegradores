package com.example.exerciciointegrador22.controller;

import com.example.exerciciointegrador22.model.Funcionario;
import com.example.exerciciointegrador22.service.IFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private IFuncionarioService service;

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario){
        return new ResponseEntity<>(service.insert(funcionario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionario){
        return new ResponseEntity<>(service.update(funcionario), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
