package br.com.meli.dh.exerciciointegrador12.dto;

import br.com.meli.dh.exerciciointegrador12.model.Veiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class VeiculoDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;

    public VeiculoDTO(Veiculo veiculo) {
        this.brand = veiculo.getBrand();
        this.model = veiculo.getModel();
        this.manufacturingDate = veiculo.getManufacturingDate();
        this.numberOfKilometers = veiculo.getNumberOfKilometers();
        this.doors = veiculo.getDoors();
        this.price = veiculo.getPrice();
        this.currency = veiculo.getCurrency();
        this.countOfOwners = veiculo.getCountOfOwners();
    }
}
