package com.example.projetojpa4.repositorios;

import com.example.projetojpa4.dominios.Carro;
import com.example.projetojpa4.visoes.CarroSimples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarroRepository extends CrudRepository<Carro,Integer> {

    @Query("select new com.example.projetojpa4.visoes.CarroSimples (c.id, c.modelo ) from Carro c")
    List<CarroSimples> findAllSimples();


}
