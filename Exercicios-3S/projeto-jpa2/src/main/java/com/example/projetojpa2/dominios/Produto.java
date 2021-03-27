package com.example.projetojpa2.dominios;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer codProduto;

    @Column(nullable = false,length = 30)
    private String nome,unidade;

    private Double preco;

    public Produto(String nome, String unidade, Double preco) {
        this.nome = nome;
        this.unidade = unidade;
        this.preco = preco;
    }

    public Produto() {
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
