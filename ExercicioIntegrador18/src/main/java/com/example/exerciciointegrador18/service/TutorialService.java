package com.example.exerciciointegrador18.service;

import com.example.exerciciointegrador18.exception.InvalidParamException;
import com.example.exerciciointegrador18.exception.NotFoundException;
import com.example.exerciciointegrador18.model.Status;
import com.example.exerciciointegrador18.model.Tutorial;
import com.example.exerciciointegrador18.repo.TutorialRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorialService implements ITutorialService{
    private final TutorialRepo repo;

    @Override
    public Tutorial save(Tutorial tutorial) {
        if(tutorial == null) throw new InvalidParamException("O tutorial não pode ser nulo");
        if(tutorial.getId() != null) throw new InvalidParamException("O tutorial não pode ser preenchido");

        tutorial.setStatus(Status.DRAFT);
        return repo.save(tutorial);
    }

    @Override
    public List<Tutorial> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Tutorial> getById(long id) {
        return repo.findById(id);
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
        return repo.findByStatusEquals(Status.PUBLISHED);
    }

    @Override
    public List<Tutorial> getAllByTitle(String title) {
        return repo.findByTituloContaining(title);
    }

    @Override
    public Tutorial updateStatusPublished(long id) {
        Optional<Tutorial> optionalTutorial = getById(id);

        if(optionalTutorial.isEmpty()) throw new NotFoundException("Tutorial não encontrado");

        Tutorial tutorial = optionalTutorial.get();
        tutorial.setStatus(Status.PUBLISHED);

        return repo.save(tutorial);
    }
}
