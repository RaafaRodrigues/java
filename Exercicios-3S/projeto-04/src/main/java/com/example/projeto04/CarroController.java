package com.example.projeto04;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/carros")
public class CarroController {

    private List<Carro> carros=new ArrayList<>();

    @GetMapping
    public List<Carro> getCarros(){
        return carros;
    }

    @GetMapping("/{id}")
    public Carro recuperarCarro(@PathVariable int id){
        return  carros.get(id-1);
    }
    @PostMapping
    public void criarCarro(@RequestBody Carro novoCarro){
        carros.add(novoCarro);
    }

    @DeleteMapping("/{id}")
    public void excluirCarro(@PathVariable int id){
        carros.remove(id-1);

    }


    @GetMapping("/populares")
    public List<Carro> carrosPopulares(){
        List<Carro> carrosPopulares= carros.stream()
                .filter(carro -> carro.getPreco() <15000)
                .collect(Collectors.toList());
        return carrosPopulares;
    }

}
