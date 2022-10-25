package com.example.exerciciointegrador18.repo;

import com.example.exerciciointegrador18.model.Status;
import com.example.exerciciointegrador18.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TutorialRepo extends JpaRepository<Tutorial, Long> {
//    @Query("select t from Tutorial t where t.status = ")
//    List<Tutorial> getAllPublished();

    @Query("select t from Tutorial t where t.titulo like %:title%")
    List<Tutorial> getAllByTitle(String title);

    // OU
    List<Tutorial> findByTituloContaining(String title);

    List<Tutorial> findByStatusEquals(Status status);
}
