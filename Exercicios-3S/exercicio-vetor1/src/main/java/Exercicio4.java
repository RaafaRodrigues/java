import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        Scanner ler =new Scanner(System.in);
        Integer[] vetorInteiros=new Integer[10];
        Integer contador=0;
        for(Integer i=0;i< vetorInteiros.length;i++){
            System.out.println("Digite um Numero :");
            vetorInteiros[i]=ler.nextInt();
        }
        System.out.println("Digite um numero para verificar quantas vezes ele ocorre no vetor");
        Integer numeroDigitado=ler.nextInt();
        for(Integer i= 0;i< vetorInteiros.length;i++){
            if(numeroDigitado==vetorInteiros[i]){
                contador++;
            }
        }

        System.out.println(contador ==0?"O numero "+numeroDigitado+" " +
                "não ocorre nenhuma vez":"O numero "+numeroDigitado+" ocorre  "+contador+" vezes");



    }
}
