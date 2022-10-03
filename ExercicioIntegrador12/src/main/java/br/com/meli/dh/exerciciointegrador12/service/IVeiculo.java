package br.com.meli.dh.exerciciointegrador12.service;

import br.com.meli.dh.exerciciointegrador12.dto.VeiculoDTO;
import br.com.meli.dh.exerciciointegrador12.exception.NotFoundException;
import br.com.meli.dh.exerciciointegrador12.model.Veiculo;

import java.time.LocalDate;
import java.util.List;

public interface IVeiculo {
    List<VeiculoDTO> getAllVeiculos();
    void saveVeiculo(Veiculo veiculo);
    Veiculo getVeiculo(int id) throws NotFoundException;
    List<VeiculoDTO> getVeiculosByDateManufacturing(LocalDate since, LocalDate to);
    List<VeiculoDTO> getVeiculosByPrice(double since, double to);
}
