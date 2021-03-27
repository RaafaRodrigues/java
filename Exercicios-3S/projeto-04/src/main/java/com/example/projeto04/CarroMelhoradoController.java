package com.example.projeto04;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carros")
public class CarroMelhoradoController {

    private List<Carro> carros=new ArrayList<>();

    @GetMapping
    public ResponseEntity getCarros(){
        return carros.isEmpty()?
                ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity recuperarCarro(@PathVariable int id){
        return  carros.size()>=id?
                ResponseEntity.status(200).body(carros.get(id-1)):
                ResponseEntity.status(404).build();
    }
    @PostMapping
    public ResponseEntity criarCarro(@RequestBody Carro novoCarro){
        carros.add(novoCarro);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirCarro(@PathVariable int id){

       if(carros.size() >=id){
           carros.remove(id-1);
           return ResponseEntity.status(200).build();
       }else{
           return ResponseEntity.status(404).build();
       }

    }


    @GetMapping("/populares")
    public ResponseEntity carrosPopulares(){

        List<Carro> carrosPopulares= carros.stream()
                .filter(carro -> carro.getPreco() <15000)
                .collect(Collectors.toList());

        return carrosPopulares.size()>0?
                ResponseEntity.ok(carrosPopulares):
                ResponseEntity.noContent().build();
    }

}
