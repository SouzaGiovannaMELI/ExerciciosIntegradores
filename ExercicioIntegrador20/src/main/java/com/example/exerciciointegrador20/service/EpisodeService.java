package com.example.exerciciointegrador20.service;

import com.example.exerciciointegrador20.model.Episode;
import com.example.exerciciointegrador20.repository.EpisodeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService implements IEpisodeService{
    private final EpisodeRepo repo;

    @Override
    public List<Episode> getAllEpisodesByActor(Long actor_id) {
        return repo.getAllByActorEpisodes(actor_id);
    }
}
