package com.example.exerciciointegrador18.controller;

import com.example.exerciciointegrador18.model.Status;
import com.example.exerciciointegrador18.model.Tutorial;
import com.example.exerciciointegrador18.service.TutorialService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TutorialController.class)
class TutorialControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TutorialService service;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void save_returnNewTutorial_whenTutorialIsValid() throws Exception {
        BDDMockito.when(service.save(ArgumentMatchers.any(Tutorial.class)))
                .thenReturn(new Tutorial(1L, "Teste 1", "Desc 1", Status.DRAFT));

        Tutorial tutorial = new Tutorial(null, "Teste 1", "Desc 1", null);

        ResultActions result = mockMvc.perform(post("/api/tutorials")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(tutorial)));

        result.andExpect(status().isCreated()).andExpect(jsonPath("$.titulo", CoreMatchers.is("Teste 1")));
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void getAllPublished() {
    }

    @Test
    void getAllByTitle() {
    }

    @Test
    void updateStatusPublished() {
    }
}