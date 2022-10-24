package com.example.exerciciointegrador17.repository;

import com.example.exerciciointegrador17.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseRepo extends JpaRepository<TestCase, Long> {
    @Query("select t from TestCase t where t.last_update >= :date")
    List<TestCase> getAllByLastUpdate(LocalDate date);
}
