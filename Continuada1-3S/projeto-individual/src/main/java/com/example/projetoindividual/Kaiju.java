package com.example.projetoindividual;

public class Kaiju extends Monstro {
    private Double tamanho,radiacao;

    public Kaiju(String nome,Integer categoria,Double furia,Double tamanho,Double radiacao){
		super(nome,categoria,furia);
		this.tamanho=tamanho;
		this.radiacao=radiacao;
    }
	//getters e setters da classe kaiju
	public Double getTamanho(){
		return tamanho;
	}
	public Double getRadiacao(){
		return radiacao;
	}
	public void setTamanho(Double tamanho){
    	this.tamanho=tamanho;
	}
	public void setRadiacao(Double radiacao){
		this.tamanho=radiacao;
	}


	//metodos da interface
	public Double getPotencial(){
		return tamanho*radiacao;
	}
	public Double getAwakened(){
    	return (getPotencial()*getFuria());
	}
	public Double getForca(){
    	return getPotencial()*getDescontrole();
	}

	//metodos da abstrata
	@Override
	public Double getDescontrole() {
		return getPotencial()*150;
	}

	//toString()

	@Override
	public String toString() {
		return super.toString()+" Kaiju{" +
				"tamanho=" + tamanho +
				", radiacao=" + radiacao +
				"} " ;
	}
}
