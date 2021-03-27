package com.example.continuada3.controllers;


import com.example.continuada3.dominios.Deus;
import com.example.continuada3.dominios.SemiDeus;
import com.example.continuada3.repositorios.SemiDeusRepository;

import com.example.continuada3.utils.PilhaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/semideuses")
public class SemiDeusController {
    private PilhaObj<SemiDeus> desfazerCadastro =new PilhaObj<>(99);

    @Autowired
    SemiDeusRepository service;


    @PostMapping
    public ResponseEntity cadastrarSemiDeus(@RequestBody SemiDeus semiDeus){
        service.save(semiDeus);
        if(!desfazerCadastro.isFull()) {
            desfazerCadastro.push(semiDeus);
        }
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public  ResponseEntity verSemiDeuses(){
        return service.count()>0?
                ResponseEntity.ok(service.findAll())
                :ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public  ResponseEntity verUmSemiDeus(@PathVariable Integer id){
        if(service.count()>0){
            if(service.existsById(id)){
                return ResponseEntity.ok(service.findById(id));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody SemiDeus attSemiDeus){
        if(service.existsById(attSemiDeus.getId())){
            SemiDeus update = service.getOne(attSemiDeus.getId());
            update.setNome(attSemiDeus.getNome());
            update.setPai(attSemiDeus.getPai());
            service.save(update);

            return ResponseEntity.ok().build();
        } else {

            return ResponseEntity.notFound().build();
        }

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
}
