package com.example.exerciciointegrador18.repo;

import com.example.exerciciointegrador18.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TutorialRepo extends JpaRepository<Tutorial, Long> {
    @Query("select t from Tutorial t where t.publicado = true")
    List<Tutorial> getAllPublished();

    @Query("select t from Tutorial t where t.titulo like %:title%")
    List<Tutorial> getAllByTitle(String title);
}
