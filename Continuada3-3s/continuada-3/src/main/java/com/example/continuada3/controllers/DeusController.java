package com.example.continuada3.controllers;

import com.example.continuada3.dominios.Deus;
import com.example.continuada3.repositorios.DeusRespository;


import com.example.continuada3.utils.PilhaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/deuses")
public class DeusController {
    private PilhaObj<Deus> desfazerCadastro = new PilhaObj<>(99);

    @Autowired
    private DeusRespository service;


    @PostMapping
    public ResponseEntity cadastrarDeus(@RequestBody Deus deus) {
        service.save(deus);
        if (!desfazerCadastro.isFull()) {
            desfazerCadastro.push(deus);
        }
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity verDeuses() {
        return service.count() > 0 ?
                ResponseEntity.ok(service.findAll())
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/desfazer")
    public ResponseEntity desfazerPost() {
        if (desfazerCadastro.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            if (service.existsById(desfazerCadastro.peek().getId())) {
                service.deleteById(desfazerCadastro.pop().getId());
                return ResponseEntity.ok().build();
            }
            desfazerCadastro.pop();
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Deus attDeus){
        if(service.existsById(attDeus.getId())){
            Deus update = service.getOne(attDeus.getId());
            update.setNome(attDeus.getNome());
            update.setPanteao(attDeus.getPanteao());
            service.save(update);

            return ResponseEntity.ok().build();
        } else {

            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/{id}")
    public  ResponseEntity verUmDeus(@PathVariable Integer id){
        if(service.count()>0){
            if(service.existsById(id)){
                return ResponseEntity.ok(service.findById(id));
            }
        }
        return ResponseEntity.notFound().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (service.existsById(id)) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
