package com.meli.obterdiploma.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
public class SubjectDTO {
    @NotEmpty(message = "O nome do assunto não pode ficar vazio")
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕ][a-záéíóúàèìòùâêîôûãõ]+", message = "A inicial do nome da matéria deve ser maiuscula")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres")
    String name;

    @DecimalMin(value = "0.0", message = "A nota mínima é 0.0")
    @DecimalMax(value = "10.0", message = "A nota máxima é 10.0")
    Double score;
}
