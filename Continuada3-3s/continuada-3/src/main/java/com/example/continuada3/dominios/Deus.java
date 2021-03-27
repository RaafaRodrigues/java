package com.example.continuada3.dominios;

import javax.persistence.*;

@Entity
public class Deus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String panteao;


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

    public String getPanteao() {
        return panteao;
    }

    public void setPanteao(String panteao) {
        this.panteao = panteao;
    }
}
