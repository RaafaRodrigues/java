package com.projeto.continuada2.repositorios;

import com.projeto.continuada2.dominios.Saiyajin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaiyajinRepository  extends JpaRepository<Saiyajin,Integer> {


}
