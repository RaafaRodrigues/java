import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {
        Scanner ler= new Scanner(System.in);
        Integer[] vetorNumeros=new Integer[10];

        Double soma=0.0;

        for (Integer c=0;c<vetorNumeros.length;c++){
            System.out.println("\nDigite um numero");
            vetorNumeros[c]= ler.nextInt();
            soma+= vetorNumeros[c];

        }

        System.out.println("\nMedia: "+(soma/ vetorNumeros.length));
        System.out.println("\nNumeros no vetor acima da media: ");
        for (Integer i=0;i< vetorNumeros.length;i++){

            if(vetorNumeros[i] > (soma/vetorNumeros.length)){
                System.out.println(vetorNumeros[i]);
            }
        }



    }
}
