package com.example.exerciciointegrador22.service;

import com.example.exerciciointegrador22.model.Produto;

import java.util.List;

public interface IProdutoService {
    Produto insert(Produto produto);
    Produto update(Produto produto);
    List<Produto> getAll();
}
