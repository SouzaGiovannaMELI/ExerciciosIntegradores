package com.example.exerciciointegrador16.service;

import com.example.exerciciointegrador16.model.Joia;
import com.example.exerciciointegrador16.repository.JoiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoiaService implements IJoia{
    @Autowired
    private JoiaRepo repo;

    @Override
    public long save(Joia joia) {
        return repo.save(joia).getId();
    }

    @Override
    public List<Joia> getAll() {
        return (List<Joia>) repo.findAll();
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public Joia update(long id, Joia joia) {
        repo.findById(id).get();
        return repo.save(joia);
    }
}
