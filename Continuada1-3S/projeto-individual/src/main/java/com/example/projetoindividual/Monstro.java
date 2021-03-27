package com.example.projetoindividual;

public abstract class Monstro implements SerVivo {
    private String nome;
    private Integer categoria;
    private Double furia;
    public Monstro(String nome,Integer categoria,Double furia){
        this.nome=nome;
        this.categoria=categoria;
        this.furia=furia;
    }
    //getters e setters do Monstro
    public String getNome(){
        return nome;
    }
    public Integer getCategoria(){
        return categoria;
    }
    public Double getFuria(){
        return furia;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setCategoria(Integer categoria){
        this.categoria=categoria;
    }
    public void  setFuria(Double furia){
        this.furia=furia;
    }




    //metodo abstrato monstro

    public abstract Double getDescontrole();


    //tostring()
    @Override
    public String toString() {
        return "Monstro{" +
                "nome='" + nome + '\'' +
                ", categoria=" + categoria +
                ", furia=" + furia +
                '}';
    }
}
