package com.example.exerciciointegrador17.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_case;

    @Column
    private String description;

    @Column
    private boolean tested;

    @Column
    private boolean passed;

    @Column
    private int number_of_tries;

    @Column
    private LocalDate last_update;
}
