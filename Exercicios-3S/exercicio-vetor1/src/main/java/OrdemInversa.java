import java.util.Scanner;

public class OrdemInversa {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        Integer[] vetor=new Integer[7];

        for(int i =0;i< vetor.length;i++){
            System.out.println("Digite o valor: ");
            vetor[i]= ler.nextInt();
        }

        for(int i= vetor.length;i!=0;i--){
            System.out.print(vetor[i-1]+"\t");
        }




    }
}
