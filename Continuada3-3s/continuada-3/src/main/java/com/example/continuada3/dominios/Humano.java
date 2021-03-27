package com.example.continuada3.dominios;

import javax.persistence.*;

@Entity
public class Humano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String idade;

    @ManyToOne
    private Deus deusAdorado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Deus getDeusAdorado() {
        return deusAdorado;
    }

    public void setDeusAdorado(Deus deusAdorado) {
        this.deusAdorado = deusAdorado;
    }
}
