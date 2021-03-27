import java.util.Scanner;

public class TesteFilme {
    public static void criaCsv(ListaObj<Filme> lista){

    }


    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Boolean loop = true;
        ListaObj<Filme> filme = new ListaObj<Filme>(5);


        while (!loop ) {
            System.out.printf("1. Adicionar um Filme\n" +
                    "2. Exibir a lista\n" +
                    "3. Gravar a lista em arquivo CSV\n" +
                    "4. Ler e exibir um arquivo CSV\n" +
                    "5. Gravar em outro arquivo CSV apenas filmes que estão na lista, mas de um determinado genero\n" +
                    "6. Sair");
            Integer escolha = ler.nextInt();
            switch (escolha) {
                case 1:

                    System.out.println("Digite o idFilme:");
                    Integer idFilme = ler.nextInt();
                    System.out.println("Digite o nome do Filme: ");
                    String nome = ler.nextLine();
                    System.out.println("Digite o genero do Filme: ");
                    String genero = ler.nextLine();
                    System.out.println("Digite a nota do Filme:");
                    Double nota = ler.nextDouble();
                    System.out.println("Digite a faixa etaria do Filme:");
                    Integer idade = ler.nextInt();
                    if (nota > 10 || nota < 0) {
                        System.out.println("Nota invalida rs");
                    } else {
                        Filme f = new Filme(idFilme, nome, nota, genero, idade);
                        filme.adiciona(f);
                    }
                    break;
                case 2:
                    filme.exibe();
                    break;
                case 3:



            }
        }
    }
}
