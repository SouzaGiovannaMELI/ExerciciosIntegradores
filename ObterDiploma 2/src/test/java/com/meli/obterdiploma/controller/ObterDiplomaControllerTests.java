package com.meli.obterdiploma.controller;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.service.IObterDiplomaService;
import com.meli.obterdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ObterDiplomaControllerTests {

    @Mock
    IObterDiplomaService service;

    @InjectMocks
    ObterDiplomaController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void obterDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @Test
    public void obterDiploma_IdIsMissing() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", -1L)).andExpect(status().isNotFound());
    }

    @Test
    public void obterDiploma_IdNotFound() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", 100)).andExpect(status().isNotFound());
    }

    @Test
    public void obterDiploma_IdaFormatIsMissing() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", "asasasa")).andExpect(status().isBadRequest());
    }

}
