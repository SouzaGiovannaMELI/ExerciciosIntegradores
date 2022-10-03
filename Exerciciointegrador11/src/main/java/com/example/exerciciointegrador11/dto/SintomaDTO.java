package com.example.exerciciointegrador11.dto;

import com.example.exerciciointegrador11.model.Sintoma;
import lombok.Data;

@Data
public class SintomaDTO {
    private String nome;

    public SintomaDTO(Sintoma sintoma) {
        this.nome = sintoma.getNome();
    }
}
