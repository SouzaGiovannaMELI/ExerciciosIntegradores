package com.example.exerciciointegrador21.service;

import com.example.exerciciointegrador21.model.Veiculo;
import com.example.exerciciointegrador21.repository.VeiculoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService implements IVeiculoService{
    private final VeiculoRepo repo;

    @Override
    public Veiculo insert(Veiculo veiculo) {
        return repo.save(veiculo);
    }

    @Override
    public List<Veiculo> getAll() {
        return repo.findAll();
    }

    @Override
    public List<String> getAllPlacas() {
        return repo.findAllPlaca();
    }

    @Override
    public List<Object> getAllPlacasAndMarcaGroupByFabricacao(int ano) {
        return repo.findAllPlacasAndMarcaGroupByFabricacao(ano);
    }

    @Override
    public List<String> getAllPlacaOnVeiculoQuatroRodasAndFabricadoAnoAtual() {
        return repo.findAllPlacaOnVeiculoQuatroRodasAndFabricadoAnoAtual();
    }

    @Override
    public List<Object> getAllPercaMaiorDezMil() {
        return repo.findAllPercaMaiorDezMil();
    }

    @Override
    public List<Object> getAllPercaMaiorDezMilViewPerda() {
        return repo.findAllPercaMaiorDezMilViewPerdaTotal();
    }
}
