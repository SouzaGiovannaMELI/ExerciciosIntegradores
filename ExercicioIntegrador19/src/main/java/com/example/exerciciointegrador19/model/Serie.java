package com.example.exerciciointegrador19.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "series")
public class Serie {
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
    private LocalDate release_date;

    @Column
    private LocalDate end_date;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonIgnoreProperties("series")
    private Genre genre;

    @OneToMany(mappedBy = "serie", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("serie")
    private List<Season> seasons;
}
