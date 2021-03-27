package com.example.projetojpa4.repositorios;

import com.example.projetojpa4.dominios.Fabricante;
import com.example.projetojpa4.visoes.FabricanteSimples;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FabricanteRepository extends CrudRepository<Fabricante,Integer> {

    @Query("select new com.example.projetojpa4.visoes.FabricanteSimples(f.nome) from Fabricante f")
    List<FabricanteSimples> findAllSimples();

}
