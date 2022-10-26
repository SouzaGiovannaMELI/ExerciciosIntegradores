package com.example.exerciciointegrador22.repository;

import com.example.exerciciointegrador22.model.Funcionario;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface FuncionarioRepo extends ElasticsearchRepository<Funcionario, Integer> {
    @Query("{\"match_all\": {}}")
    List<Funcionario> findAll();
}
