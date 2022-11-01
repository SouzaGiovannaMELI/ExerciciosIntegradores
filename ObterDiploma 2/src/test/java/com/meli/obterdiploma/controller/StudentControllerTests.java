package com.meli.obterdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.service.IStudentService;
import com.meli.obterdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registerStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.registerStudent(stu);

        // assert
        verify(service, atLeastOnce()).create(stu);
    }

    @Test
    public void registerStudent_throwMethodArgumentNotValidException_whenParamIsMissing() throws Exception {
        StudentDTO stu = new StudentDTO();

        mockMvc.perform(post("/student/registerStudent")
                .content("")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.read(stu.getId())).thenReturn(stu);

        // act
        StudentDTO readStu = controller.getStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void getStudent_idNumberInvalid() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", -1L)).andExpect(status().isNotFound());
    }

    @Test
    public void getStudent_idNotFound() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 100)).andExpect(status().isNotFound());
    }

    @Test
    public void getStudent_idFormatIsMissing() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", "asasa")).andExpect(status().isBadRequest());
    }

    @Test
    public void modifyStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.modifyStudent(stu);

        // assert
        verify(service, atLeastOnce()).update(stu);
    }

    @Test
    public void removeStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.removeStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void removeStudent_idIsNegative() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", -1L)).andExpect(status().isNotFound());
    }

    @Test
    public void removeStudent_idIsInvalid() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", "ddadadas")).andExpect(status().isBadRequest());
    }

    @Test
    public void removeStudent_idNotFound() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 100)).andExpect(status().isNotFound());
    }

    @Test
    public void listStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(service.getAll()).thenReturn(students);

        // act
        Set<StudentDTO> readStudents = controller.listStudents();

        // assert
        verify(service, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}
