package com.example.exerciciointegrador18.repository;

import com.example.exerciciointegrador18.model.Status;
import com.example.exerciciointegrador18.model.Tutorial;
import com.example.exerciciointegrador18.repo.TutorialRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TutorialRepoTest {
    @Autowired
    private TutorialRepo repo;

    @BeforeEach
    public void setup(){
        repo.deleteAll();
    }

    @Test
    public void save_returnTutorial_whenTutorialIdValid(){
        Tutorial newTutorial = new Tutorial(null, "Teste 1", "Estamos fazendo um teste", Status.DRAFT);

        Tutorial tutorialSaved = repo.save(newTutorial);

        assertThat(tutorialSaved).isNotNull();
        assertThat(tutorialSaved.getId()).isPositive();
        assertThat(tutorialSaved.getStatus()).isEqualTo(Status.DRAFT);
        assertThat(tutorialSaved.getTitulo()).isEqualTo(newTutorial.getTitulo());
    }

    @Test
    public void findById_returnTutorial_whenIdTutorialExist(){
        Tutorial tutorialSaved = repo.save(new Tutorial(null, "Teste 1", "Estamos fazendo um teste", Status.DRAFT));

        Optional<Tutorial> tutorialSearch = repo.findById(tutorialSaved.getId());

        assertThat(tutorialSearch).isPresent();
        assertThat(tutorialSearch.get().getId()).isPositive();
        assertThat(tutorialSearch.get().getStatus()).isEqualTo(tutorialSaved.getStatus());
        assertThat(tutorialSearch.get().getTitulo()).isEqualTo(tutorialSaved.getTitulo());
    }

    @Test
    public void findById_returnOptionalEmpty_whenIdTutorialNotExist(){
        Optional<Tutorial> tutorialSearch = repo.findById(1L);

        assertThat(tutorialSearch).isEmpty();
    }

    @Test
    public void findByStatus_returnListTutorial_whenStatusExist(){
        Tutorial tutorialSaved = repo.save(new Tutorial(null, "Teste 1", "Estamos fazendo um teste", Status.DRAFT));

        List<Tutorial> tutorials = repo.findByStatusEquals(Status.DRAFT);

        assertThat(tutorials).hasSize(1);
        assertThat(tutorials.get(0).getStatus()).isEqualTo(tutorialSaved.getStatus());
        assertThat(tutorials.get(0).getId()).isEqualTo(tutorialSaved.getId());
    }

    @Test
    public void findByStatus_returnEmptyList_whenStatusNotExist(){
        List<Tutorial> tutorials = repo.findByStatusEquals(Status.DRAFT);

        assertThat(tutorials).isEmpty();
    }

    @Test
    public void findByTituloContaining_returnListTutorial_whenTitleContainingExists(){
        Tutorial tutorialSaved = repo.save(new Tutorial(null, "Teste 1", "Estamos fazendo um teste", Status.DRAFT));

        List<Tutorial> tutorials = repo.findByTituloContaining("1");

        assertThat(tutorials).hasSize(1);
        assertThat(tutorials.get(0).getStatus()).isEqualTo(tutorialSaved.getStatus());
        assertThat(tutorials.get(0).getId()).isEqualTo(tutorialSaved.getId());
    }

    @Test
    public void findByTituloContaining_returnEmptyList_whenTitleContainingExists(){
        Tutorial tutorialSaved = repo.save(new Tutorial(null, "Teste 1", "Estamos fazendo um teste", Status.DRAFT));

        List<Tutorial> tutorials = repo.findByTituloContaining("2");

        assertThat(tutorials).isEmpty();
    }
}
