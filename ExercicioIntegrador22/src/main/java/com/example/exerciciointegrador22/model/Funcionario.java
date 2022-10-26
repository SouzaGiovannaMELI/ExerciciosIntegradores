package com.example.exerciciointegrador22.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "funcionarios")
public class Funcionario {
    @Id
    private String id;
    private String nome;
    private String sobrenome;
    private int idade;
    private String cidade;
    private String estado;
}
