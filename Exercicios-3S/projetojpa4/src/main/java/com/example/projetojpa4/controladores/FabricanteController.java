package com.example.projetojpa4.controladores;


import com.example.projetojpa4.repositorios.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteRepository repository1;

    @GetMapping
    public ResponseEntity getFabricanteSimples(){
        return ResponseEntity.ok(repository1.findAllSimples());
    }
}
