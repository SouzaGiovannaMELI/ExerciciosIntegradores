package com.example.exerciciointegrador18.service;

import com.example.exerciciointegrador18.model.Tutorial;

import java.util.List;

public interface ITutorialService {
    Tutorial save(Tutorial tutorial);
    List<Tutorial> getAll();
    Tutorial getById(long id);
    Tutorial updateById(long id, Tutorial tutorial);
    void deleteAll();
    void deleteById(long id);
    List<Tutorial> getAllPublished();
    List<Tutorial> getAllByTitle(String title);
}
