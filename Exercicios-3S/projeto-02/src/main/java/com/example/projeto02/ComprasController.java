package com.example.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/compras")

public class ComprasController {
        private List lista = new ArrayList<>();

    @GetMapping("/comprar/{item}/{valor}/{quantidade}")
    public void cadastrarCompra(@PathVariable String item,@PathVariable double valor,@PathVariable int quantidade){
        lista.add("Item: "+item);
        lista.add("Valor: "+valor);
        lista.add("Quantidade: "+quantidade);


    }

    @GetMapping("/compras")
    public List getLista(){
        return lista;

    }
}
