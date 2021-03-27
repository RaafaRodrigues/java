package com.example.projeto02;

public class Item {
    private String item;
    private Double valor;
    private Integer qtd;

    public Item(String item, Double valor, Integer qtd) {
        this.item = item;
        this.valor = valor;
        this.qtd = qtd;
    }

    public String getItem() {
        return item;
    }

    public double getValor() {
        return valor;
    }

    public int getQtd() {
        return qtd;
    }
}
