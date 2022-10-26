package com.example.exerciciointegrador19.service;

import com.example.exerciciointegrador19.model.Episode;
import com.example.exerciciointegrador19.repository.EpisodeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService implements IEpisodeService{
    private EpisodeRepo repo;

    @Override
    public Episode insert(Episode episode) {
        return repo.save(episode);
    }

    @Override
    public List<Episode> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
