package com.projeto.continuada2.utils;

import com.projeto.continuada2.dominios.Namekuseijin;
import com.projeto.continuada2.dominios.Saiyajin;
import com.projeto.continuada2.utils.ListaObj;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class MetodoCriarLer {


    public void gerarCsvSaiyajin(ListaObj<Saiyajin> lista ) {
        if(lista.getTamanho()>0) {
            FileWriter arq = null;
            Formatter saida = null;
            boolean error = false;
            String nomeArquivo = "saiyajin.csv";
            Path currentRelativePath = Paths.get("");
            String url = currentRelativePath.toAbsolutePath().toString() + "/saiyajin.csv";
            File downloadFile = new File(url);



            try {
                arq = new FileWriter(nomeArquivo, true);
                saida = new Formatter(arq);
            } catch (IOException erro) {
                System.err.println("Erro ao abrir arquivo");
                System.exit(1);
            }


            try {

                for (int i = 0; i < lista.getTamanho(); i++) {

                    Saiyajin s = lista.getElemento(i);

                        saida.format("%d;%s;%d;%d;%s;%s;%s%n", s.getId(),
                                s.getNome(), s.getNivelTransformacao(), s.getUniverso().getId(),
                                s.getUniverso().getNome()
                                , s.getUniverso().getDeusDestruicao(), s.getUniverso().getAnjo());

                }

            } catch (FormatterClosedException erro) {
                System.err.println("Erro ao gravar no arquivo");
                error = true;
            } finally {
                saida.close();
                try {
                    arq.close();
                } catch (IOException erro) {
                    System.err.println("Erro ao fechar arquivo.");
                    error = true;
                }
                if (error) {
                    System.exit(1);
                }

            }
        }
    }

    public void gerarCsvNamek(ListaObj<Namekuseijin> lista) {

        FileWriter arq = null;
        Formatter saida = null;
        boolean error = false;

        String nomeArquivo = "namek.csv";



        try {
            arq = new FileWriter(nomeArquivo, true);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }


        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Namekuseijin n = lista.getElemento(i);


                saida.format("%d;%s;%.2f;%d;%s;%s;%s%n", n.getId(),
                        n.getNome(), n.getRegeneracao(),n.getUniverso().getId(),
                        n.getUniverso().getNome(),n.getUniverso().getDeusDestruicao()
                        ,n.getUniverso().getAnjo());


            }
        } catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            error = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                error = true;
            }
            if (error) {
                System.exit(1);
            }
        }
    }

    public void lerArquivoCsv(boolean isSaiyajin) {
        FileReader arq= null;
        Scanner entrada = null;
        String nomeArquivo ;
        boolean error= false;

        if (isSaiyajin) {
            nomeArquivo=  "saiyajin.csv";
        }
        else {
            nomeArquivo= "namek.csv";
        }


        try {
            arq = new FileReader(nomeArquivo);
            entrada = new Scanner(arq).useDelimiter(";|\\r\\n");

        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1);
        }


        try {
            if(isSaiyajin) {
                System.out.printf("%-8s%-10s%21s%17s%20s%27s%17s\n", "ID", "NOME", "Nivel Transformação","FK_UNIVERSO","NOME","DEUS","ANJO");
            }else{
                System.out.printf("%-8s%-11s%21s%18s%20s%27s%17s\n", "ID", "NOME", "Regeneração","FK_UNIVERSO","NOME","DEUS","ANJO");
            }
            while (entrada.hasNext()) {
                if(isSaiyajin) {
                    Integer id = entrada.nextInt();
                    String nome = entrada.next();
                    Integer nivelTransformacao = entrada.nextInt();
                    Integer fkUniverso=entrada.nextInt();
                    String nomeUniverso=entrada.next();
                    String deus=entrada.next();
                    String anjo = entrada.next();
                    System.out.printf("%-8d%-10s%21d%17d%20s%27s%17s\n", id, nome, nivelTransformacao,fkUniverso,nomeUniverso,deus,anjo);
                }else{
                    Integer id = entrada.nextInt();
                    String nome = entrada.next();
                    Double regeneracao = entrada.nextDouble();
                    Integer fkUniverso=entrada.nextInt();
                    String nomeUniverso=entrada.next();
                    String deus=entrada.next();
                    String anjo = entrada.next();
                    System.out.printf("%-8d%-10s%22.2f%18d%20s%27s%17s\n", id, nome, regeneracao,fkUniverso,nomeUniverso,deus,anjo);


                }
            }
        }
        catch (NoSuchElementException erro)
        {
            System.err.println("Arquivo com problemas.");
            error = true;
        }
        catch (IllegalStateException erro)
        {
            System.err.println("Erro na leitura do arquivo.");
            error = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                error= true;
            }
            if (error) {
                System.exit(1);
            }
        }
    }
    public  void gravaRegistro (String nomeArq, String registro) {
        BufferedWriter saida = null;
        try {

            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();

        } catch (IOException e) {
            System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
        }
    }
    public  void leArquivo() {
        BufferedReader entrada = null;
        String registro;
        String tipoRegistro;


            String  id, nome, nomeUni, deus, anjo;
            double regenaracao;
            int idUniverso, contRegistro = 0;


            try {
                entrada = new BufferedReader(new FileReader("namek.txt"));
            } catch (IOException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
            }


            try {

                registro = entrada.readLine();

                while (registro != null) {

                    tipoRegistro = registro.substring(0, 2);

                    if (tipoRegistro.equals("12")) {
                        System.out.println("Header");
                        System.out.println("Tipo de arquivo: " + registro.substring(2, 14));
                        int anoReferencia = Integer.parseInt(registro.substring(14, 18));
                        System.out.println("Ano: " + anoReferencia);
                        System.out.println("Data/hora de geração do arquivo: " + registro.substring(18, 37));
                        System.out.println("Versão do layout: " + registro.substring(37, 39));
                    } else if (tipoRegistro.equals("02")) {
                        System.out.println("\nTrailer");
                        int qtdRegistro = Integer.parseInt(registro.substring(2, 12));
                        if (qtdRegistro == contRegistro) {
                            System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                        } else {
                            System.out.println("Quantidade de registros gravados não confere com quantidade lida");
                        }
                    } else if (tipoRegistro.equals("01")) {
                        if (contRegistro == 0) {
                            System.out.println();
                            System.out.printf("%-8s %-11s %34s %19s %13s %29s %17s\n\n", "ID", "NOME", "Regeneração","FK_UNIVERSO","NOME","DEUS","ANJO");

                        }


                        id =(registro.substring(2, 6));
                        nome = registro.substring(6, 45);
                        regenaracao = Double.parseDouble(registro.substring(45, 51).replace(',', '.'));
                        idUniverso = Integer.valueOf(registro.substring(51, 53));
                        nomeUni = registro.substring(53, 64);
                        deus = registro.substring(64, 74);
                        anjo = registro.substring(74, 84);

                        System.out.printf("%-8s %-10s %1.2f %20d %20s %27s %17s\n", id, nome, regenaracao, idUniverso,
                                nomeUni, deus, anjo);
                        contRegistro++;
                    } else {
                        System.out.println("Tipo de registro inválido");
                    }

                    // lê o próximo registro
                    registro = entrada.readLine();
                }

                // Fecha o arquivo
                entrada.close();
            } catch (IOException e) {
                System.err.printf("Erro ao ler arquivo: %s.\n", e.getMessage());
            }

    }

    public void gerarTxtLayoutNamek(ListaObj<Namekuseijin> lista) {

        String nomeArq = "namek.txt";
        String header = "";
        String corpo = "";
        String trailer = "";
        int contRegDados = 0;
        Date dataDeHoje = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        header += "12NAMEKUSEIJIN2020";
        header += formatter.format(dataDeHoje);
        header += "20";


        gravaRegistro(nomeArq, header);

        for (Integer i = 0; i < lista.getTamanho(); i++) {
            Namekuseijin n = lista.getElemento(i);


            if (i == 0) {
                corpo += "01";
                corpo += String.format("%-4d", n.getId());
                corpo += String.format("%-39s", n.getNome());
                corpo += String.format("%06.2f", n.getRegeneracao());
                corpo += String.format("%02d", n.getUniverso().getId());
                corpo += String.format("%-12s", n.getUniverso().getNome());
                corpo += String.format("%-10s", n.getUniverso().getDeusDestruicao());
                corpo += String.format("%-10s", n.getUniverso().getAnjo());

                contRegDados++;

                gravaRegistro(nomeArq, corpo);
            } else {
                corpo = "01";
                corpo += String.format("%-4d", n.getId());
                corpo += String.format("%-39s", n.getNome());
                corpo += String.format("%06.2f", n.getRegeneracao());
                corpo += String.format("%02d", n.getUniverso().getId());
                corpo += String.format("%-12s", n.getUniverso().getNome());
                corpo += String.format("%-10s", n.getUniverso().getDeusDestruicao());
                corpo += String.format("%-10s", n.getUniverso().getAnjo());

                contRegDados++;

                gravaRegistro(nomeArq, corpo);
            }

        }
        trailer += "02";
        trailer += String.format("%010d", contRegDados);
        gravaRegistro(nomeArq, trailer);
    }


}
