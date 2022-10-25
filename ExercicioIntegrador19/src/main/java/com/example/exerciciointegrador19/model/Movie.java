package com.example.exerciciointegrador19.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    @Column(length = 500)
    private String title;

    @Column(columnDefinition = "decimal", precision =  5, scale = 1)
    private double rating;

    @Column
    private int awards;

    @Column
    private LocalDate release_date;

    @Column
    private int lenght;

    @OneToMany(mappedBy = "favorite_movie_id", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("favorite_movie_id")
    private List<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonIgnoreProperties("movies")
    private Genre genre;

    @OneToMany(mappedBy = "movie")
    private List<ActorMovie> actorMovieList;
}
