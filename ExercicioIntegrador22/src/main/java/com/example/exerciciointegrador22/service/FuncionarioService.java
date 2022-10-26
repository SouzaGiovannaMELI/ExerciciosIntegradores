package com.example.exerciciointegrador22.service;

import com.example.exerciciointegrador22.model.Funcionario;
import com.example.exerciciointegrador22.repository.FuncionarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService implements IFuncionarioService{
    private final FuncionarioRepo repo;

    @Override
    public Funcionario insert(Funcionario funcionario) {
        return repo.save(funcionario);
    }

    @Override
    public Funcionario update(Funcionario funcionario) {
        return repo.save(funcionario);
    }

    @Override
    public List<Funcionario> getAll() {
        return repo.findAll();
    }
}
