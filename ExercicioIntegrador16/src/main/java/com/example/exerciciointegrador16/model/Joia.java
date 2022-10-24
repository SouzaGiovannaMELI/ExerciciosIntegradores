package com.example.exerciciointegrador16.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Joia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String material;

    @Column(nullable = false, precision = 2)
    private double peso;

    @Column(nullable = false)
    private int quilates;
}
