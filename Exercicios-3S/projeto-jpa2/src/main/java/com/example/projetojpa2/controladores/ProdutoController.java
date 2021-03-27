package com.example.projetojpa2.controladores;

import com.example.projetojpa2.dominios.Produto;
import com.example.projetojpa2.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ResponseEntity criar(@RequestBody Produto novoProduto){
        repository.save(novoProduto);
        return ResponseEntity.created(null).build();
    }


    @GetMapping("/true")
    public ResponseEntity pesquisar(){
       return repository.count()>0?ResponseEntity.ok(repository.findAll()):ResponseEntity.noContent().build();
    }

    @GetMapping("/caros")
    public ResponseEntity listaCaros(){
        return  ResponseEntity.ok(repository.pesquisarPorPrecoQue(6.0));
    }

    @GetMapping
    public  ResponseEntity pesquisar(@RequestParam(required = false)String nome,
                                    @RequestParam(required = false)String unidade,
                                    @RequestParam(required = false)Double preco){

        Produto produtoPesquisa = new Produto(nome,unidade,preco);

        List<Produto> produtos= repository.findAll(Example.of(produtoPesquisa));

        return produtos.isEmpty()? ResponseEntity.noContent().build():ResponseEntity.ok(produtos);

    }

}
