package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Actor;

import java.util.List;

public interface IActorService {
    Actor insert(Actor actor);
    List<Actor> getAll();
    void delete(int id);
}
