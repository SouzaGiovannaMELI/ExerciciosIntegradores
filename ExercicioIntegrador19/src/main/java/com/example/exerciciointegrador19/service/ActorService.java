package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Actor;
import com.example.exerciciointegrador19.repository.ActorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService implements IActorService{
    private final ActorRepo repo;

    @Override
    public Actor insert(Actor actor) {
        return repo.save(actor);
    }

    @Override
    public List<Actor> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
