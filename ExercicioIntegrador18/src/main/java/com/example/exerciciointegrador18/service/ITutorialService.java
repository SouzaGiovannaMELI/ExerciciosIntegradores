package com.example.exerciciointegrador18.service;

import com.example.exerciciointegrador18.model.Status;
import com.example.exerciciointegrador18.model.Tutorial;

import java.util.List;
import java.util.Optional;

public interface ITutorialService {
    Tutorial save(Tutorial tutorial);
    List<Tutorial> getAll();
    Optional<Tutorial> getById(long id);
    Tutorial updateById(long id, Tutorial tutorial);
    void deleteAll();
    void deleteById(long id);
    List<Tutorial> getAllPublished();
    List<Tutorial> getAllByTitle(String title);

    Tutorial updateStatusPublished(long id);
}
