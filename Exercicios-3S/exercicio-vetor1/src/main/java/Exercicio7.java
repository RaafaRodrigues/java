import java.sql.SQLOutput;
import java.util.Scanner;

public class Exercicio7 {

    public static void cadastraVetor(Integer[] v){
        for (Integer i = 0; i < v.length; i++) {
            Scanner ler = new Scanner(System.in);
            Integer numeroDigitado;
            System.out.println("Digite um NUMERO: ");
            numeroDigitado = ler.nextInt();
            v[i] = numeroDigitado;

            for (Integer in = 0; in < i; in++) {
                if (v[i] < v[in]) {
                    Integer temp = v[i];
                    v[i] = v[in];
                    v[in] = temp;
                }
            }

        }
    }

    public static void exibeVetor(Integer[] v){
        for (Integer i : v) {

            System.out.print(i + "\t");
        }
    }

    public static void main(String[] args) {

        Integer[] vetor1 = new Integer[5];
        Integer[] vetor2 = new Integer[5];
        Integer[] vetor3=new Integer[10];


        System.out.println("Cadastrando o primeiro vetor: ");
        cadastraVetor(vetor1);
        System.out.println("Cadastrando o Segundo  vetor: ");
        cadastraVetor(vetor2);


        for (Integer i=0;i<vetor3.length-vetor1.length;i++){
                       vetor3[i]=vetor1[i];
        }
        for (Integer i=0;(i<vetor3.length-vetor2.length);i++){

            vetor3[i+vetor2.length]=vetor2[i];
        }
        for (Integer i = 0; i < vetor3.length; i++) {

            for (Integer in = 0; in < i; in++) {
                if (vetor3[i] < vetor3[in]) {
                    Integer temp = vetor3[i];
                    vetor3[i] = vetor3[in];
                    vetor3[in] = temp;
                }
            }
        }

        System.out.println("\n Mostrando ordenado o vetor1");
        exibeVetor(vetor1);
        System.out.println("\n Mostrando ordenado o vetor2");
        exibeVetor(vetor2);
        System.out.println("\n Mostrando ordenado o vetor3");
        for (int i:vetor3){
            System.out.print(i+"\t");
        }
       


    }
}
