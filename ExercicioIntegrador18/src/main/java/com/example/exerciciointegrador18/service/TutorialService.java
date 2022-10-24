package com.example.exerciciointegrador18.service;

import com.example.exerciciointegrador18.model.Tutorial;
import com.example.exerciciointegrador18.repo.TutorialRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorialService implements ITutorialService{
    private final TutorialRepo repo;


    @Override
    public Tutorial save(Tutorial tutorial) {
        return repo.save(tutorial);
    }

    @Override
    public List<Tutorial> getAll() {
        return repo.findAll();
    }

    @Override
    public Tutorial getById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public Tutorial updateById(long id, Tutorial tutorial) {
        tutorial.setId(id);
        return repo.save(tutorial);
    }

    @Override
    public void deleteAll() {
        repo.deleteAll();
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Tutorial> getAllPublished() {
        return repo.getAllPublished();
    }

    @Override
    public List<Tutorial> getAllByTitle(String title) {
        return repo.getAllByTitle(title);
    }
}
