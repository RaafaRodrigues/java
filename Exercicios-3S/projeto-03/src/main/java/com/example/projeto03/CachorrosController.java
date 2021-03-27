package com.example.projeto03;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/cachorros")
public class CachorrosController {
    private List<Cachorro> listaCachorros=new ArrayList<Cachorro>();

    @GetMapping("/lista")
    public List<Cachorro> getListaCachorros() {
        return listaCachorros;
    }

    //Getter para recuperar o primeiro cachorro da lista => id-1 = indice 0;
    @GetMapping("/recuperar/{id}")
    public Cachorro getCachorro(@PathVariable Integer id){
        return listaCachorros.get(id-1);
    }
    @PostMapping("/cadastrar")
    public void cadastrarCachorro(@RequestBody Cachorro novoCachorro){
        listaCachorros.add(novoCachorro);
    }

    @DeleteMapping("/excluir/{id}")
    public void deletarCachorro(@PathVariable Integer id){
        listaCachorros.remove(id-1);
    }
    @PutMapping("/atualizar/{id}")
    public void atualizarCachorro(@PathVariable Integer id , @RequestBody Cachorro cachorro){
        listaCachorros.set(id-1,cachorro);

    }

}
