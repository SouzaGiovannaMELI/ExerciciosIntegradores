package com.example.exerciciointegrador22.service;

import com.example.exerciciointegrador22.model.Produto;
import com.example.exerciciointegrador22.repository.ProdutoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService implements IProdutoService{
    private final ProdutoRepo repo;

    @Override
    public Produto insert(Produto produto) {
        return repo.save(produto);
    }

    @Override
    public Produto update(Produto produto) {
        return repo.save(produto);
    }

    @Override
    public List<Produto> getAll() {
        return repo.findAll();
    }
}
