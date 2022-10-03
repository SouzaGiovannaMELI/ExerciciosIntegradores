package com.example.exerciciointegrador11.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sintoma {
    private static int indice = 0;

    private int codigo;
    private String nome;
    private int nivelDeGravidade;

    public Sintoma(String nome, int nivelDeGravidade) {
        this.nome = nome;
        this.nivelDeGravidade = nivelDeGravidade;

        this.codigo = indice++;
    }
}
