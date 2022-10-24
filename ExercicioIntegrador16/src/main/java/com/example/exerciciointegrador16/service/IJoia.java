package com.example.exerciciointegrador16.service;

import com.example.exerciciointegrador16.model.Joia;

import java.util.List;

public interface IJoia {
    long save(Joia joia);
    List<Joia> getAll();
    void delete(long id);
    Joia update(long id, Joia joia);
}
