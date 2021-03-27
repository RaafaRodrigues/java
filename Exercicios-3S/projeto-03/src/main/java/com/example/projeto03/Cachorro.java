package com.example.projeto03;

public class Cachorro {
    private String raca;
    private Double preco;

    public Cachorro(String raca, Double preco) {
        this.raca = raca;
        this.preco = preco;
    }

    public String getRaca() {
        return raca;
    }

    public Double getPreco() {
        return preco;
    }
}
