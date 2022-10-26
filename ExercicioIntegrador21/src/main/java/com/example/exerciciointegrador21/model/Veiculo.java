package com.example.exerciciointegrador21.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 8)
    private String placa;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column(columnDefinition = "year")
    private int fabricacao;

    @Column
    private int rodas;

    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("veiculo")
    private List<Sinistro> sinistros;
}
