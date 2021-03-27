package com.projeto.continuada2.utils;

public class ListaObj <T> {
    private T[] vetor;
    private Integer nroElem;




    public ListaObj(Integer tamanho) {
        this.vetor =  (T[]) new Object[tamanho];
        this.nroElem = 0;
    }



    public Boolean adiciona(T valor) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista está cheia");
            return false;
        }
        else {
            vetor[nroElem++] = valor;
            return true;
        }
    }



    public void exibe() {
        System.out.println("\nExibindo elementos da lista:");
        for (int i=0; i< nroElem; i++) {
            System.out.print(vetor[i] + "\t");
        }
        System.out.println();
    }


    public Integer busca(T valor) {
        for (int i=0; i < nroElem; i++) {
            if (vetor[i].equals( valor)) {
                return i;
            }
        }
        return -1;
    }


    public Boolean removePeloIndice(int indice) {

        if (indice < 0 || indice >= nroElem) {
            return false;
        }
        else {

            for (int i=indice; i < nroElem-1; i++) {
                vetor[i] = vetor[i+1];
            }

            nroElem--;
            return true;
        }
    }
    public Boolean listaCheia(){
       if(this.getTamanho()>=vetor.length){
           return true;
       }else{
           return false;
       }
    }


    public Boolean removeElemento(T valor) {

        return removePeloIndice(busca(valor));
    }
    public Integer getTamanho(){
        return nroElem;
    }
    public T getElemento(Integer i){


        return i>=nroElem||i<0?null:vetor[i];
    }

    public void limpa(){
        nroElem=0;
    }


}
