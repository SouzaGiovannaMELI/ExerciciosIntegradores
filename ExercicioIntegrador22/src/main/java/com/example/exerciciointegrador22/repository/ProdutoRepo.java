package com.example.exerciciointegrador22.repository;

import com.example.exerciciointegrador22.model.Produto;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProdutoRepo extends ElasticsearchRepository<Produto, Integer> {
    @Query("{\"match_all\": {}}")
    List<Produto> findAll();
}
