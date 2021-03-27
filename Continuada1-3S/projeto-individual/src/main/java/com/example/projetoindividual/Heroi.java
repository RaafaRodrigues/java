package com.example.projetoindividual;

public class Heroi extends Humano {
    private Integer nivel;
    private Double energia;

    public Heroi(String codiNome, Integer identificador, Double poder, Integer nivel, Double energia) {
        super(codiNome, identificador, poder);
        this.nivel = nivel;
        this.energia = energia;

    }
    //getters e setters Heroi

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Double getEnergia() {
        return energia;
    }

    public void setEnergia(Double energia) {
        this.energia = energia;
    }

    //metodos interface
    public Double getPotencial() {
        return (getPoder() * nivel);
    }

    public Double getForca() {
        return ((getPoder() * nivel) / energia);
    }

    public Double getAwakened() {
        return (getForca() * 100);

    }

    //metodos classe abstrata


    @Override
    public Double getSuperacao() {
        return getForca() * 10;
    }

    @Override
    public Double getInspiracao() {
        return (getForca() * 2);
    }

    //toString()

    @Override
    public String toString() {
        return  super.toString()+" Heroi{" +
                "nivel=" + nivel +
                ", energia=" + energia +
                "} " ;
    }
}
