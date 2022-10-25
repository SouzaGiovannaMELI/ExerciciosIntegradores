package com.example.exerciciointegrador18.integration;

import com.example.exerciciointegrador18.model.Status;
import com.example.exerciciointegrador18.model.Tutorial;
import com.example.exerciciointegrador18.repo.TutorialRepo;
import com.example.exerciciointegrador18.service.TutorialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TutorialControllerTestIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private TutorialRepo repo;

    @BeforeEach
    public void setup(){
        repo.deleteAll();
    }

    @Test
    void save_returnNewTutorial_whenTutorialIsValid() throws Exception {
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