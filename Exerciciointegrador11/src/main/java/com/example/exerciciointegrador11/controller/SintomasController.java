package com.example.exerciciointegrador11.controller;

import com.example.exerciciointegrador11.dto.PessoaDTO;
import com.example.exerciciointegrador11.dto.SintomaDTO;
import com.example.exerciciointegrador11.model.Pessoa;
import com.example.exerciciointegrador11.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/covid")
public class SintomasController {
    List<Sintoma> sintomas = new ArrayList<>();
    List<PessoaDTO> pessoas = new ArrayList<>();

    public SintomasController(){
        sintomas.add(new Sintoma("Falta de Ar", 10));
        sintomas.add(new Sintoma("Perda de Olfato", 8));
        sintomas.add(new Sintoma("Perda de Paladar", 9));

        pessoas.add(new PessoaDTO(new Pessoa("Giovanna", "Souza", 19)));
        pessoas.add(new PessoaDTO(new Pessoa("Maria", "Aparecida", 70)));
        pessoas.add(new PessoaDTO(new Pessoa("Isidorio", "Inacio", 72)));
        pessoas.add(new PessoaDTO(new Pessoa("Lidia", "Alfieri", 85)));

        pessoas.get(2).addSintoma(sintomas.get(2));
        pessoas.get(0).addSintoma(sintomas.get(2));
        pessoas.get(1).addSintoma(sintomas.get(2));
        pessoas.get(1).addSintoma(sintomas.get(1));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findSymptom(){
        return new ResponseEntity<>(sintomas, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> findSymptom(@PathVariable String name){
        return new ResponseEntity<>(sintomas.stream().filter(sintoma -> sintoma.getNome().equals(name)).findFirst().get(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PessoaDTO>> findRiskPerson(){
        return new ResponseEntity<>(pessoas.stream().filter(pessoa -> pessoa.getIdade() >= 60).filter(pessoa -> pessoa.getSintomas().size() > 0).collect(Collectors.toList()), HttpStatus.OK);
    }
}
