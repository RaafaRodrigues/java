import java.util.Scanner;

public class ExemploMatriz {


    public static void main(String[] args) {
        Scanner ler=new Scanner(System.in);
        Integer[][] matriz=new Integer[3][4];


    for (Integer linha=0;linha<matriz.length;linha++){
        for(Integer coluna = 0;coluna < matriz[linha].length ; coluna++){
            System.out.println("Digite um valor para a linha e coluna");
            matriz[linha][coluna]=ler.nextInt();
        }
    }
        for (Integer linha=0;linha<matriz.length;linha++){
            for(Integer coluna = 0;coluna < matriz[linha].length ; coluna++){

                System.out.print(matriz[linha][coluna]+"\t");
            }
            System.out.println();
        }




    }
}
