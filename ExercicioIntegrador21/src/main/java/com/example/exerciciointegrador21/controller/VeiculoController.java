package com.example.exerciciointegrador21.controller;

import com.example.exerciciointegrador21.model.Veiculo;
import com.example.exerciciointegrador21.service.IVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private IVeiculoService service;

    @PostMapping
    public ResponseEntity<Veiculo> insert(@RequestBody Veiculo veiculo){
        return new ResponseEntity<>(service.insert(veiculo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/all-placa")
    public ResponseEntity<List<String>> getAllPlaca(){
        return new ResponseEntity<>(service.getAllPlacas(), HttpStatus.OK);
    }

    @GetMapping("/all-group-by-fabricacao/{ano}")
    public ResponseEntity<List<Object>> getAllGroupByFabricacao(@PathVariable int ano){
        return new ResponseEntity<>(service.getAllPlacasAndMarcaGroupByFabricacao(ano), HttpStatus.OK);
    }

    @GetMapping("/all-where-quatro-rodas-fabricacao-ano-atual")
    public ResponseEntity<List<String>> getAllPlacaOnVeiculoQuatroRodasAndFabricadoAnoAtual(){
        return new ResponseEntity<>(service.getAllPlacaOnVeiculoQuatroRodasAndFabricadoAnoAtual(), HttpStatus.OK);
    }

    @GetMapping("/all-perca-dez-mil")
    public ResponseEntity<List<Object>> getAllPercaDezMil(){
        return new ResponseEntity<>(service.getAllPercaMaiorDezMil(), HttpStatus.OK);
    }

    @GetMapping("/all-perca-dez-mil-view-perda")
    public ResponseEntity<List<Object>> getAllPercaDezMilViewPerda(){
        return new ResponseEntity<>(service.getAllPercaMaiorDezMilViewPerda(), HttpStatus.OK);
    }
}
