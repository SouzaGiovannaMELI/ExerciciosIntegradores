package com.meli.obterdiploma.service;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObterDiplomaServiceTest {
    @InjectMocks
    private StudentService service;

    @Mock
    private IStudentDAO dao;

//    @Test
//    void save_throwException_quando(){
//        List<SubjectDTO> subjects = new ArrayList<>();
//        subjects.add(new SubjectDTO("Matemática", 10.0));
//        subjects.add(new SubjectDTO("História", 10.0));
//
//        StudentDTO student = new StudentDTO(1L, "Giovanna", "teste", 10.0, subjects);
//        service.create(student);
//    }
}
