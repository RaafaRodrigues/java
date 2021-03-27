package com.example.continuada3.controllers;

import com.example.continuada3.dominios.Deus;
import com.example.continuada3.dominios.Humano;
import com.example.continuada3.repositorios.HumanoRepository;

import com.example.continuada3.utils.PilhaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/humanos")
public class HumanoController {
    private PilhaObj<Humano> desfazerCadastro =new PilhaObj<>(99);
    @Autowired
    HumanoRepository service;


    @PostMapping
    public ResponseEntity cadastrarHumano(@RequestBody Humano humano){
        service.save(humano);
        if(!desfazerCadastro.isFull()) {
            desfazerCadastro.push(humano);
        }
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public  ResponseEntity verHumanos(){
        return service.count()>0?
                ResponseEntity.ok(service.findAll())
                :ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public  ResponseEntity verUmHumano(@PathVariable Integer id){
       if(service.count()>0){
           if(service.existsById(id)){
               return ResponseEntity.ok(service.findById(id));
           }
       }
       return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/desfazer")
    public ResponseEntity desfazerPost(){
        if(desfazerCadastro.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            if (service.existsById(desfazerCadastro.peek().getId())) {
                service.deleteById(desfazerCadastro.pop().getId());
                return ResponseEntity.ok().build();
            }
            desfazerCadastro.pop();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if(service.existsById(id)){
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Humano attHumano){
        if(service.existsById(attHumano.getId())){
            Humano update = service.getOne(attHumano.getId());
            update.setNome(attHumano.getNome());
            update.setIdade(attHumano.getIdade());
            update.setDeusAdorado(attHumano.getDeusAdorado());
            service.save(update);

            return ResponseEntity.ok().build();
        } else {

            return ResponseEntity.notFound().build();
        }

    }
}
