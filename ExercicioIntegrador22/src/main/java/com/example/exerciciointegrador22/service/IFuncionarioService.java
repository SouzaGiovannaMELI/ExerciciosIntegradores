package com.example.exerciciointegrador22.service;

import com.example.exerciciointegrador22.model.Funcionario;

import java.util.List;

public interface IFuncionarioService {
    Funcionario insert(Funcionario funcionario);
    Funcionario update(Funcionario funcionario);
    List<Funcionario> getAll();
}
