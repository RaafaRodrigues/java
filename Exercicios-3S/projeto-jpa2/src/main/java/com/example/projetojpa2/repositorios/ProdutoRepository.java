package com.example.projetojpa2.repositorios;

import com.example.projetojpa2.dominios.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    @Query("select p from Produto p where p.preco >?1")
    List<Produto> pesquisarPorPrecoQue(Double preco);


}
