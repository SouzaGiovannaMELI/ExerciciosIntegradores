package com.example.exerciciointegrador21.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Sinistro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDate data;

    @Column
    private double perda_economica;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    @JsonIgnoreProperties("sinistros")
    private Veiculo veiculo;
}
