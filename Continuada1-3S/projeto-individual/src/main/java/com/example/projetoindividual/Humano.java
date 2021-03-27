package com.example.projetoindividual;

public abstract class Humano implements SerVivo {

    private String codiNome;
    private Integer identificador;
    private Double poder;

    public Humano(String codiNome, Integer identificador, Double poder) {
        this.codiNome = codiNome;
        this.identificador = identificador;
        this.poder = poder;
    }

    public String getCodiNome() {
        return codiNome;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public Double getPoder() {
        return poder;
    }

    public void setCodiNome(String codiNome) {
        this.codiNome = codiNome;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public void setPoder(Double poder) {
        this.poder = poder;
    }

    public abstract  Double getSuperacao();

    public abstract  Double getInspiracao();

    @Override
    public String toString() {
        return "Humano{" +
                "codiNome='" + codiNome + '\'' +
                ", identificador=" + identificador +
                ", poder=" + poder +
                '}';
    }
}
