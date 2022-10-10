package com.meli.obterdiploma.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class StudentDTO {
    @NotEmpty(message = "O nome do aluno não pode ficar vazio")
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕ][a-záéíóúàèìòùâêîôûãõ]+", message = "A inicial do nome deve ser maiuscula")
    @Size(max = 50, message = "o comprimento do nome não pode exceder 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "A lista não pode estar vazia")
    List<@Valid SubjectDTO> subjects;
}
