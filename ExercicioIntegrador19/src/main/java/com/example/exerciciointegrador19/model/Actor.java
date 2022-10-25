package com.example.exerciciointegrador19.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    @Column(length = 100)
    private String first_name;

    @Column(length = 100)
    private String last_name;

    @Column(columnDefinition = "decimal", precision =  5, scale = 1)
    private double rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    @JsonIgnoreProperties("actors")
    private Movie favorite_movie_id;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.REMOVE)
    private List<ActorMovie> actorMovieList;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.REMOVE)
    private List<ActorEpisode> actorEpisodeList;
}
