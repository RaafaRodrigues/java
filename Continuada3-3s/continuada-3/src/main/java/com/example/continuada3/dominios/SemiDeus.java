package com.example.continuada3.dominios;

import javax.persistence.*;

@Entity
public class SemiDeus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private Deus pai;


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

    public Deus getPai() {
        return pai;
    }

    public void setPai(Deus pai) {
        this.pai = pai;
    }
}
