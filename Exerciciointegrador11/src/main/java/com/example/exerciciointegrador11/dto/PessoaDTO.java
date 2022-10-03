package com.example.exerciciointegrador11.dto;

import com.example.exerciciointegrador11.model.Pessoa;
import com.example.exerciciointegrador11.model.Sintoma;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PessoaDTO {
    private String nome;
    private String sobrenome;
    private int idade;
    private List<SintomaDTO> sintomas = new ArrayList<>();

    public PessoaDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.sobrenome = pessoa.getSobrenome();
        this.idade = pessoa.getIdade();
    }

    public void addSintoma(Sintoma sintoma){
        sintomas.add(new SintomaDTO(sintoma));
    }
}
