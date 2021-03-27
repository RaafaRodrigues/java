package com.example.projetoindividual;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
@RestController
@RequestMapping("/servivos")
public class ConfrontoController {
    private List<SerVivo> lista;

    public ConfrontoController() {
        this.lista = new ArrayList<>();

    }

    public Double getForcaTotalMonstros() {
        System.out.println("Calculando o Poder Total dos Monstros...");

        Double total = 0.00;
        if (lista.isEmpty()) {
            System.out.println("\n A lista está vazia");
        } else {
            for (SerVivo s : lista) {
                if (s instanceof Monstro) {
                    total += s.getForca();
                }
            }
        }
        if (total == 0.00) {
            System.out.println("\n Não tem monstros cadastrados");
        } else {
            System.out.println("Total:");

        }
        return total;
    }

    public Double getForcaTotalHumanos() {
        System.out.println("Calculando o Poder Total dos Humanos...");
        Double total = 0.00;
        if (lista.isEmpty()) {
            System.out.println("\n A lista está vazia");
        } else {
            for (SerVivo s : lista) {
                if (s instanceof Humano) {
                    total += s.getForca();
                }
            }
        }
        if (total == 0.00) {
            System.out.println("\n Não tem humanos cadastrados");

        } else {

            System.out.println("Total: ");

        }
        return total;

    }
    public void addSerVivo(SerVivo s){
        lista.add(s);

    }

    @PostMapping("/monstro/kaiju")
    public ResponseEntity addKaiju(@RequestBody Kaiju k) {
        lista.add(k);
        return ResponseEntity.status(201).build();

    }
    @PostMapping("/humano/jaeger")
    public ResponseEntity addJaeger(@RequestBody Jaegers j) {
        lista.add(j);
        return ResponseEntity.status(201).build();
    }
    @PostMapping("/humano/heroi")
    public ResponseEntity addHeroi(@RequestBody Heroi h) {
        lista.add(h);
        return ResponseEntity.status(201).build();

    }

    public void confronto(Humano h, Monstro m) {
        if (h instanceof Heroi) {
            System.out.println(String.format("\n O Meu Deus há um monstro aterrorizante na cidade" +
                    " O governo Classificou ele como um monstro Categoria: %d  ... \n estamos perdidos ooooh apareceu um Heroi para" +
                    " nos defender o nome dele é  %s  será se estamos a salvo? \n\n O Combate começa entre o Monstro e o Heroi", m.getCategoria(), h.getCodiNome()));

            if (h.getForca() > m.getForca()) {
                System.out.println(String.format("\n Oh a força do Heroi %s está muito acima da força do monstro sera se o embate vai terminar?", h.getCodiNome()));
                if ((h.getPoder() + h.getForca()) > (m.getForca() + m.getFuria())) {
                    System.out.println(String.format("\n OOH o monstro está caido sera o fim ?"));
                    if ((h.getForca() + h.getPoder()) > m.getAwakened()) {
                        System.out.println(String.format("\n Estamos a salvo o Heroi %s venceu o Monstro terrivel", h.getCodiNome()));
                    } else {
                        System.out.println(String.format("\n O Monstro %s levou a melhor sentiremos sua falta Heroi %s", m.getNome(), h.getCodiNome()));
                    }
                } else {
                    System.out.println(String.format("\n O Heroi está caido sera o fim?"));
                    if ((h.getForca() + h.getPoder()) > m.getAwakened()) {
                        System.out.println(String.format("\n Estamos a salvo o Heroi %s venceu o Monstro terrivel", h.getCodiNome()));
                    } else {
                        System.out.println(String.format("\n O Monstro %s levou a melhor sentiremos sua falta Heroi %s", m.getNome(), h.getCodiNome()));
                    }
                }
            } else {
                System.out.println(String.format("\n O Monstro conhecido como %s  tem uma força inacreditavel o que o Heroi %s " +
                        "poderá fazer??? ", m.getNome(), h.getCodiNome()));
                if ((h.getPoder() + h.getForca()) > (m.getForca() + m.getFuria())) {
                    System.out.println(String.format("\n OOH o monstro está caido sera o fim ?"));
                    if ((h.getForca() + h.getPoder()) > m.getAwakened()) {
                        System.out.println(String.format("\n Estamos a salvo o Heroi %s venceu o Monstro terrivel ", h.getCodiNome()));
                    } else {
                        System.out.println(String.format("\n O Monstro %s levou a melhor sentiremos sua falta Heroi %s", m.getNome(), h.getCodiNome()));
                    }
                } else {
                    System.out.println(String.format("\n O Heroi está caido sera o fim?"));
                    if ((h.getForca() + h.getPoder()) > m.getAwakened()) {

                        System.out.println(String.format("\n Estamos a salvo o Heroi %s venceu o Monstro terrivel", h.getCodiNome()));
                    } else {
                        System.out.println(String.format("\n O Monstro %s levou a melhor sentiremos sua falta Heroi %s", m.getNome(), h.getCodiNome()));
                    }
                }
            }
        }
        if (h instanceof Jaegers) {
            System.out.println(String.format("\n O Meu Deus há um monstro aterrorizante na cidade" +
                    " O governo Classificou ele como um monstro Categoria: %d  ... \n estamos perdidos ooooh apareceu um Jaeger para" +
                    " nos defender o nome dele é  %s com os " +
                    "pilotos  %s e %s  será se estamos a salvo? \n\n O Combate começa entre o Monstro e o Jaeger ", m.getCategoria(), h.getCodiNome(), ((Jaegers) h).getNomePrimeiroPiloto(), ((Jaegers) h).getNomeSegundoPiloto()));
            if (h.getForca() > m.getForca()) {
                System.out.println(String.format("\n Oh a força do Jaeger  %s está muito acima da força do monstro sera se o embate vai terminar?", h.getCodiNome()));
                if ((h.getPoder() + h.getForca()) > (m.getForca() + m.getFuria())) {
                    System.out.println(String.format("\n OOH o monstro está caido sera o fim ?"));
                    if ((h.getForca() + h.getPoder()) > m.getAwakened()) {
                        System.out.println(String.format("\n Estamos a salvo o Jaeger %s com os pilotos %s e %s venceu o Monstro terrivel", h.getCodiNome(),((Jaegers) h).getNomePrimeiroPiloto(),((Jaegers) h).getNomeSegundoPiloto()));
                    } else {
                        System.out.println(String.format("\n O Monstro %s levou a melhor o Jaeger %s está destruido! sentiremos falta de voces %s e %s", m.getNome(), h.getCodiNome(),((Jaegers) h).getNomePrimeiroPiloto(),((Jaegers) h).getNomePrimeiroPiloto()));
                    }
                } else {
                    System.out.println(String.format("\n O Jaeger está caido sera o fim?"));
                    if ((h.getForca() + h.getPoder()) > m.getAwakened()) {
                        System.out.println(String.format("\n Estamos a salvo o Jaeger %s com os pilotos %s e %s venceu o Monstro terrivel", h.getCodiNome(),((Jaegers) h).getNomePrimeiroPiloto(),((Jaegers) h).getNomeSegundoPiloto()));
                    } else {
                        System.out.println(String.format("\n O Monstro %s levou a melhor o Jaeger %s está destruido! sentiremos falta de voces %s e %s", m.getNome(), h.getCodiNome(),((Jaegers) h).getNomePrimeiroPiloto(),((Jaegers) h).getNomeSegundoPiloto()));
                    }
                }
            } else {
                System.out.println(String.format("\n O Monstro conhecido como %s  tem uma força inacreditavel o que o Jaeger %s " +
                        "poderá fazer??? ", m.getNome(), h.getCodiNome()));
                if ((h.getPoder() + h.getForca()) > (m.getForca() + m.getFuria())) {
                    System.out.println(String.format("\n OOH o monstro está caido sera o fim ?"));
                    if ((h.getForca() + h.getPoder()) > m.getAwakened()) {
                        System.out.println(String.format("\n Estamos a salvo o Jaeger %s com os pilotos %s %s venceu o Monstro terrivel", h.getCodiNome(),((Jaegers) h).getNomePrimeiroPiloto(),((Jaegers) h).getNomeSegundoPiloto()));
                    } else {
                        System.out.println(String.format("\n O Monstro %s levou a melhor o Jaeger %s está destruido! sentiremos falta de voces %s e %s", m.getNome(), h.getCodiNome(),((Jaegers) h).getNomePrimeiroPiloto(),((Jaegers) h).getNomePrimeiroPiloto()));
                    }
                } else {
                    System.out.println(String.format("\n O Jaeger está caido sera o fim?"));
                    if ((h.getForca() + h.getPoder()) > m.getAwakened()) {
                        System.out.println(  String.format("\n Estamos a salvo o Jaeger %s com os pilotos %s %s venceu o Monstro terrivel", h.getCodiNome(),((Jaegers) h).getNomePrimeiroPiloto(),((Jaegers) h).getNomeSegundoPiloto()));
                    } else {
                        System.out.println(String.format("\n O Monstro %s levou a melhor o Jaeger %s está destruido! sentiremos falta de voces %s e %s", m.getNome(), h.getCodiNome(),((Jaegers) h).getNomePrimeiroPiloto(),((Jaegers) h).getNomeSegundoPiloto()));
                    }
                }
            }


        }

    }
    @GetMapping("/humanos")
    public ResponseEntity exibirTodosHumanos(){
        System.out.println(" \nExibindo Todos os Humanos : ");
        List<SerVivo> humanos= lista.stream().filter(humano->humano instanceof Humano).collect(Collectors.toList());

        if(humanos.isEmpty()){
            System.out.println("\n A lista de Humanos está vazia ! ");
        }else{
           return humanos.size()<1? ResponseEntity.noContent().build():ResponseEntity.ok(humanos);
        }
        return humanos.size()<1? ResponseEntity.noContent().build():ResponseEntity.ok(humanos);

    }
    @GetMapping("/monstros")
    public ResponseEntity exibirTodosMonstros(){
        System.out.println("\nExibindo Todos os Monstros : ");
        List<SerVivo> monstros= lista.stream().filter(monstro -> monstro instanceof Monstro).collect(Collectors.toList());
        if(monstros.isEmpty()){
            System.out.println("\n A lista está vazia ! ");
        }else{

            return  monstros.size()>0?ResponseEntity.ok(monstros):ResponseEntity.noContent().build();
        }
        return monstros.size()<1?ResponseEntity.noContent().build():ResponseEntity.ok(monstros);
    }

    @GetMapping()
    public ResponseEntity exibirTodosSerVivos(){
        System.out.println("\n Exibindo todos os seres Vivos");
        return lista.size()<1? ResponseEntity.notFound().build():ResponseEntity.ok(lista);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletarUmSerVivo(@PathVariable Integer id){

       if(lista.size() >=id ){
           lista.remove(id-1);
           return ResponseEntity.ok().build();

       }else{
           return ResponseEntity.notFound().build();
       }


    }

    @Override
    public String toString() {
        return "ConfrontoController{" +
                "lista=" + lista +
                '}';
    }
}
