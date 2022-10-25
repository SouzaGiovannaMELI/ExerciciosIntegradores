package com.example.exerciciointegrador18.service;

import com.example.exerciciointegrador18.model.Status;
import com.example.exerciciointegrador18.model.Tutorial;
import com.example.exerciciointegrador18.repo.TutorialRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TutorialServiceTest {
    @InjectMocks
    private TutorialService service;

    @Mock
    private TutorialRepo repo;

    @Test
    void save_returnNewTutorial_whenTutorialValid() {
        BDDMockito.when(repo.save(ArgumentMatchers.any(Tutorial.class)))
                .thenReturn(new Tutorial(1L, "Teste 1", "Desc 1", Status.DRAFT));

        Tutorial newTutorial = service.save(new Tutorial(null, "Teste 1", "Desc 1", null));

        assertThat(newTutorial).isNotNull();
        assertThat(newTutorial.getId()).isPositive();
        assertThat(newTutorial.getStatus()).isEqualTo(Status.DRAFT);
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