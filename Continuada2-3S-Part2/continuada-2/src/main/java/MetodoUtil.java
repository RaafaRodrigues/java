import java.util.Scanner;

public class MetodoUtil {
    Scanner ler = new Scanner(System.in);
    Scanner lerS= new Scanner(System.in);
    public void preencheMatriz(Double[][] matriz,String[] vetorStrings){
            for (Integer linhas = 0; linhas < matriz.length; linhas++) {
                System.out.println("Digite o Nome do Saiyajin");
                String nomeAluno = lerS.nextLine();

                if (nomeAluno == null || nomeAluno == "") {
                    System.out.println("Nome invalido");
                    System.exit(1);
                } else {
                    vetorStrings[linhas] = nomeAluno;
                    for (Integer coluna = 0; coluna < matriz[linhas].length; coluna++) {
                        Boolean controle= true;
                        while (controle) {
                            System.out.println("Digite o " + (coluna + 1) + " Poder desse Saiyajin");
                            Double poder = ler.nextDouble();

                            if (poder == null || poder < 0 || poder > 9999) {
                                System.out.println("\nPoder invalido");

                            } else {
                                matriz[linhas][coluna] = poder;
                                controle= false;
                            }
                        }
                    }
                }
            }
    }

    public void mostraDados(Double[][] matriz,String[] vetorStrings,Double[] mediaColunas,Double[] mediaLinhas){

        for(Integer coluna=0;coluna< matriz.length;coluna++){
            Double media=0.0;

            for(Integer linha=0;linha< matriz[coluna].length;linha++){
                media+=matriz[coluna][linha];
            }
            mediaLinhas[coluna]=media;
        }

        for(Integer coluna=0;coluna<matriz[0].length;coluna++) {
            Double mediaC=0.00;
            for (Integer linha = 0; linha < matriz.length; linha++) {
                mediaC += matriz[linha][coluna];
            }
            mediaColunas[coluna] = mediaC;
        }

        System.out.printf("%-20s %12s %12s %21s","NOME","PODER 1","PODER 2","MEDIA SAIYAJIN");
        for (Integer linha = 0; linha < matriz.length; linha++) {
            System.out.printf("%n%-20s",vetorStrings[linha]);
            for (Integer coluna = 0; coluna< matriz[0].length; coluna++) {
            System.out.printf("%13.2f",matriz[linha][coluna]);
            }
            System.out.printf("%22.2f",mediaLinhas[linha]/mediaColunas.length);
        }

        System.out.printf("%n%n%-20s","MEDIA:");
        for (Integer linha = 0; linha < matriz[0].length; linha++) {
            System.out.printf("%13.2f",mediaColunas[linha]/mediaLinhas.length);
        }


    }

    public void loop(Boolean loop)  {
        Double[][] matriz;
        Double[] mediasColunas, mediaLinhas;
        String[] vetorStrings;
        while (loop) {

            System.out.println("Digite a quantidades de Linhas da Matriz");
            Integer matrizLinhas = ler.nextInt();
            if (matrizLinhas > 10 || matrizLinhas < 1) {
                System.out.println("Linhas tem que ser entre 1 e 10");
            } else {
                matriz = new Double[matrizLinhas][2];
                vetorStrings = new String[matrizLinhas];
                mediaLinhas = new Double[matrizLinhas];
                mediasColunas = new Double[2];

                preencheMatriz(matriz, vetorStrings);
                mostraDados(matriz, vetorStrings, mediasColunas, mediaLinhas);

                loop=false;

            }
        }
    }
}
