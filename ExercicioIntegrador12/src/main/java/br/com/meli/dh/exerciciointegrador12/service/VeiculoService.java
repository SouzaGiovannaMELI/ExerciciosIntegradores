package br.com.meli.dh.exerciciointegrador12.service;

import br.com.meli.dh.exerciciointegrador12.dto.VeiculoDTO;
import br.com.meli.dh.exerciciointegrador12.exception.NotFoundException;
import br.com.meli.dh.exerciciointegrador12.model.Veiculo;
import br.com.meli.dh.exerciciointegrador12.repository.VeiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VeiculoService implements IVeiculo{
    private VeiculoRepo repo = new VeiculoRepo();
    @Override
    public List<VeiculoDTO> getAllVeiculos() {
        return repo.getAll();
    }

    @Override
    public void saveVeiculo(Veiculo veiculo) {
        repo.saveVeiculo(veiculo);
    }

    @Override
    public Veiculo getVeiculo(int id) throws NotFoundException {
        Optional<Veiculo> veiculo = repo.getVeiculo(id);

        if(veiculo.isEmpty())
            return null;
        return veiculo.get();
    }

    @Override
    public List<VeiculoDTO> getVeiculosByDateManufacturing(LocalDate since, LocalDate to) {
        return getAllVeiculos().stream()
                .filter(veiculo -> veiculo.getManufacturingDate().isAfter(since))
                .filter(veiculo -> veiculo.getManufacturingDate().isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public List<VeiculoDTO> getVeiculosByPrice(double since, double to) {
        return getAllVeiculos().stream()
                .filter(veiculo -> veiculo.getPrice() >= since)
                .filter(veiculo -> veiculo.getPrice() <= to)
                .collect(Collectors.toList());
    }
}
