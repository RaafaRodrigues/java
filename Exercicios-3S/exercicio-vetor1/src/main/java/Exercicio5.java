import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {
        Scanner lerS = new Scanner(System.in);
        Scanner lerD = new Scanner(System.in);
        String[] vetorMarcas = new String[5];
        Double[] vetorKm = new Double[5];
        Integer lugar=0;
        Double economico = 0.00;

        for (Integer i = 0; i < vetorMarcas.length; i++) {

            System.out.println("Digite a marca do carro: ");
            vetorMarcas[i] = lerS.nextLine();
            System.out.println("Quantos km faz com 1 litro");
            vetorKm[i] = lerD.nextDouble();
            if(i==0){
                economico=vetorKm[i];
            }
            if (vetorKm[i] > economico) {

                economico = vetorKm[i];
                lugar=i;
            }

        }

        System.out.println("\n Mais economico: "+vetorMarcas[lugar]);


    }
}
