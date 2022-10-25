package com.example.exerciciointegrador19.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    @Column(length = 100)
    private String name;

    @Column
    private boolean active;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("genre")
    private List<Serie> series;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("genre")
    private List<Movie> movies;
}
