package com.projeto.continuada2.dominios;

import javax.persistence.*;

@Entity
public class Universo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String deusDestruicao;

    private String anjo;

    public String getDeusDestruicao() {
        return deusDestruicao;
    }

    public void setDeusDestruicao(String deusDestruicao) {
        this.deusDestruicao = deusDestruicao;
    }

    public String getAnjo() {
        return anjo;
    }

    public void setAnjo(String anjo) {
        this.anjo = anjo;
    }

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




}
