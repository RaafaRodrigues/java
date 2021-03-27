package com.example.projetojpa3;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Pessoa {

    @NotNull(message = "Onde já se viu uma pessoa sem nome")
    @Length(min=2,max=40)
    private String nome;

    @Min(0) @Max(30)
    // @Range(min=0,max=30)
    private Integer filhos;

    @Past
    //@PastOrPresent
    //@Future
    private LocalDate nascimento;

    @Pattern(regexp = "[0-9]{5}-[0-9]{3}")
    private String cep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFilhos() {
        return filhos;
    }

    public void setFilhos(Integer filhos) {
        this.filhos = filhos;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
