package com.example.exerciciointegrador21.service;

import com.example.exerciciointegrador21.model.Veiculo;

import java.util.List;

public interface IVeiculoService {
    Veiculo insert(Veiculo veiculo);
    List<Veiculo> getAll();
    List<String> getAllPlacas();
    List<Object> getAllPlacasAndMarcaGroupByFabricacao(int ano);
    List<String> getAllPlacaOnVeiculoQuatroRodasAndFabricadoAnoAtual();
    List<Object> getAllPercaMaiorDezMil();
    List<Object> getAllPercaMaiorDezMilViewPerda();
}
