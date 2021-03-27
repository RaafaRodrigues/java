import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner lerS= new Scanner(System.in);
        Integer cont=0;
        String[] vetorStrings=new String[10];

        for(int i= 0; i <vetorStrings.length;i++){
            System.out.println("Digite um nome");
            vetorStrings[i]= lerS.nextLine();
        }
        System.out.println("Digite um nome para pesquisa");
        String lido= lerS.nextLine();
        for(int i=0;i< vetorStrings.length;i++){
            if(vetorStrings[i].equals(lido)){
                System.out.println("Nome: "+vetorStrings[i]+" encontrado no Indice: "+(i+1));
                cont++;
            }
        }
        if(cont==0){
            System.out.println("\n Nome não encontrado");
        }
    }
}
