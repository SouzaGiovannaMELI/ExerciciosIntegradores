package com.example.exerciciointegrador22.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "produtos")
public class Produto {
    @Id
    private String id;
    private String nome;
    private String categoria;
    private double preco;
    private int qtd;
    private String armazem;
}
