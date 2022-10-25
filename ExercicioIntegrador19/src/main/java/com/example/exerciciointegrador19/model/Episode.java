package com.example.exerciciointegrador19.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    @Column(length = 500)
    private String title;

    @Column
    private int number;

    @Column
    private LocalDate release_date;

    @Column(columnDefinition = "decimal", precision =  5, scale = 1)
    private double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    @JsonIgnoreProperties("episodes")
    private Season season;
}
