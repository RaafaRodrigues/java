package com.example.continuada3.repositorios;


import com.example.continuada3.dominios.Humano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanoRepository extends JpaRepository<Humano, Integer> {
}
