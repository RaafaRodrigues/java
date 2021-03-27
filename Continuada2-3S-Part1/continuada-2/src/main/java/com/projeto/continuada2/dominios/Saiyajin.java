package com.projeto.continuada2.dominios;


import javax.persistence.*;

@Entity
public class Saiyajin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private  Integer nivelTransformacao;

    @ManyToOne
    private Universo universo;


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

    public Integer getNivelTransformacao() {
        return nivelTransformacao;
    }

    public void setNivelTransformacao(Integer nivelTransformacao) {
        this.nivelTransformacao = nivelTransformacao;
    }

    public Universo getUniverso() {
        return universo;
    }

    public void setUniverso(Universo universo) {
        this.universo = universo;
    }
}
