package com.example.projetoindividual;

public class Jaegers extends  Humano {
    private String nomePrimeiroPiloto,nomeSegundoPiloto;
    private  Double versaoJaeger,altura;

    public Jaegers(String codiNome, Integer identificador,Double poder,String nomePrimeiroPiloto,String nomeSegundoPiloto,Double versaoJaeger,Double altura){
        super(codiNome,identificador,poder);
        this.nomePrimeiroPiloto=nomePrimeiroPiloto;
        this.nomeSegundoPiloto=nomeSegundoPiloto;
        this.versaoJaeger=versaoJaeger;
        this.altura=altura;
    }
    //getters e setter Jaegers


    public String getNomePrimeiroPiloto() {
        return nomePrimeiroPiloto;
    }

    public void setNomePrimeiroPiloto(String nomePrimeiroPiloto) {
        this.nomePrimeiroPiloto = nomePrimeiroPiloto;
    }

    public String getNomeSegundoPiloto() {
        return nomeSegundoPiloto;
    }

    public void setNomeSegundoPiloto(String nomeSegundoPiloto) {
        this.nomeSegundoPiloto = nomeSegundoPiloto;
    }

    public Double getVersaoJaeger() {
        return versaoJaeger;
    }

    public void setVersaoJaeger(Double versaoJaeger) {
        this.versaoJaeger = versaoJaeger;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    //metodos da interface
    public Double getPotencial() {
        return (altura*versaoJaeger);
    }

    public Double getForca() {
        return (getPotencial()*getPoder());
    }

    public Double getAwakened() {
        return getForca()*100;
    }

    //metodos classe abstrata
    @Override
    public Double getSuperacao() {
        return getForca()*10;
    }

    @Override
    public Double getInspiracao() {
        return getForca()*2;
    }

    //toString()
    @Override
    public String toString() {
        return super.toString()+" Jaegers{" +
                "nomePrimeiroPiloto='" + nomePrimeiroPiloto + '\'' +
                ", nomeSegundoPiloto='" + nomeSegundoPiloto + '\'' +
                ", versaoJaeger=" + versaoJaeger +
                ", altura=" + altura +
                "} " ;
    }
}
