package com.example.exerciciointegrador19.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "seasons")
public class Season {
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

    @Column
    private LocalDate end_date;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    @JsonIgnoreProperties("seasons")
    private Serie serie;

    @OneToMany(mappedBy = "season", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("season")
    private List<Episode> episodes;
}
