package com.example.exerciciointegrador19.repository;

import com.example.exerciciointegrador19.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepo extends JpaRepository<Actor, Integer> {
}
