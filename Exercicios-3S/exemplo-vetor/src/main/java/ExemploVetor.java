import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Scanner;

public class ExemploVetor {

    public static void exibeVetor(Integer[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("v[" + i + "]" + v[i] + "\t");
        }
    }

    public static Double exibeSoma(Integer[] v) {
        double soma = 0.00;
        for (int i = 0; i < v.length; i++) {
            soma += v[i];
        }
        return soma;
    }

    public static Integer exibePar(Integer[] v) {
        int qtd = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                qtd++;
            }
        }
        return qtd;
    }


    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        Integer[] vetor = new Integer[5];
        Integer[] vetor2 = {100, 200, 300, 400, 500, 600, 700};
        String[] vetor3 = new String[5];
        Integer[] vetorDinamica;

        Integer tamanho;

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i * 10;
        }


        exibeVetor(vetor);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("\nDigite o valor de vetor[" + i + "]");
            vetor[i] = ler.nextInt();
        }

        exibeVetor(vetor);
        exibeVetor(vetor2);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("\nDigite o valor de vetor[" + i + "]");
            vetor3[i] = ler.next();
        }

        for (String s : vetor3) {
            System.out.print(s + "\t");
        }

        System.out.println();

        String[] vetorSemana = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado"};
        System.out.println("Digite um numero de 1 a 7");


        Boolean verdade = false;
        while (verdade == false) {

            switch (ler.nextInt()) {
                case 1:
                    System.out.println(vetorSemana[0]);
                    verdade = true;
                    break;
                case 2:
                    System.out.println(vetorSemana[1]);
                    verdade = true;
                    break;
                case 3:
                    System.out.println(vetorSemana[2]);
                    verdade = true;
                    break;
                case 4:
                    System.out.println(vetorSemana[3]);
                    verdade = true;
                    break;
                case 5:
                    System.out.println(vetorSemana[4]);
                    verdade = true;
                    break;
                case 6:
                    System.out.println(vetorSemana[5]);
                    verdade = true;
                    break;
                case 7:
                    System.out.println(vetorSemana[6]);
                    verdade = true;
                    break;
                default:
                    System.out.println("\nDigite um numero valido!\n");
                    break;
            }

            System.out.println("qtd " + exibePar(vetor));
            System.out.println("soma:" + exibeSoma(vetor));
            System.out.println();

            System.out.println("Qual tamanho voce quer o vetor");
            tamanho = ler.nextInt();
            while (tamanho <= 2) {
                System.out.println("tamanho invalido digite novamente");
                tamanho = ler.nextInt();
            }
            vetorDinamica=new Integer[tamanho];

            for(Integer i=0;i< vetorDinamica.length;i++){
                System.out.println("digite os valores");
                vetorDinamica[i]=ler.nextInt();
            }
            exibeVetor(vetorDinamica);


        }


    }
}
