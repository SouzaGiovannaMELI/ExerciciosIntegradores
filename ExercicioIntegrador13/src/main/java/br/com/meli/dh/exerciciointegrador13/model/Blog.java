package br.com.meli.dh.exerciciointegrador13.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private int id;
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = LocalDate.parse(dataPublicacao);
    }
}
