package com.example.exerciciointegrador17.service;

import com.example.exerciciointegrador17.model.TestCase;
import com.example.exerciciointegrador17.repository.TestCaseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TestCaseService implements ITestCaseService{
    private final TestCaseRepo repo;

    @Override
    public TestCase insert(TestCase test) {
        return repo.save(test);
    }

    @Override
    public List<TestCase> getAll() {
        return repo.findAll();
    }

    @Override
    public TestCase getById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public TestCase updateById(long id, TestCase test) {
        test.setId_case(id);
        return repo.save(test);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<TestCase> getAllByLastUpdate(LocalDate date) {
        return repo.getAllByLastUpdate(date);
    }
}
