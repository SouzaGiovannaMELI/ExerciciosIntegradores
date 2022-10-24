package com.example.exerciciointegrador17.service;

import com.example.exerciciointegrador17.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCase insert(TestCase test);
    List<TestCase> getAll();
    TestCase getById(long id);
    TestCase updateById(long id, TestCase test);
    void delete(long id);
    List<TestCase> getAllByLastUpdate(LocalDate date);
}
