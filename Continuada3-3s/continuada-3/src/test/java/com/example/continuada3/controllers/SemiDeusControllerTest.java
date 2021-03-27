package com.example.continuada3.controllers;


import com.example.continuada3.dominios.SemiDeus;
import com.example.continuada3.repositorios.SemiDeusRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = SemiDeusController.class)
class SemiDeusControllerTest {

    @Autowired
    SemiDeusController controller;

    @MockBean
    SemiDeusRepository repository;

    @Test
    @DisplayName("verSemiDeuses() deve trazer semiDeuses status 200")
    void getVerSemiDeuses1() {

        List<SemiDeus> semiDeuses =
                Arrays.asList(Mockito.mock(SemiDeus.class));

        Mockito.when(repository.findAll()).thenReturn(semiDeuses);

        ResponseEntity resposta = controller.verSemiDeuses();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(semiDeuses, resposta.getBody());
    }

    @Test
    @DisplayName("verSemiDeuses() deve trazer semiDeuses status 404")
    void getVerSemiDeuses2() {

        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = controller.verSemiDeuses();

        assertEquals(404, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }
    @Test
    @DisplayName("delete() status 404 e sem corpo caso id não exista")
    void deleteCenario1() {
        Integer id = 51;
        Mockito.when(repository.existsById(id)).thenReturn(false);

        ResponseEntity resposta = controller.delete(id);

        assertEquals(404, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }
    @Test
    @DisplayName("delete() status 200 e sem corpo caso id exista")
    void deleteCenario2() {
        Integer id = 92;
        Mockito.when(repository.existsById(id)).thenReturn(true);

        ResponseEntity resposta = controller.delete(id);

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }
    @Test
    @DisplayName("cadastrarSemiDeus() status 201 caso cadastre")
    void cadastrarCenario1() {
        SemiDeus semiDeus =Mockito.mock(SemiDeus.class);
        Mockito.when(repository.save(semiDeus)).thenReturn(semiDeus);

        ResponseEntity resposta = controller.cadastrarSemiDeus(semiDeus);

        assertEquals(201, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }

    @Test
    @DisplayName("atualizar() retorna 201 se conseguir alterar")
    void atualizar1(){
        SemiDeus semiDeus =Mockito.mock(SemiDeus.class);
        Mockito.when(repository.save(semiDeus)).thenReturn(semiDeus);

        ResponseEntity resposta = controller.atualizar(semiDeus);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());


    }
    @Test
    @DisplayName("atualizar() retorna 404 se não encontrar o usuario para  alterar")
    void atualizar2(){
        SemiDeus semiDeus =Mockito.mock(SemiDeus.class);
        Mockito.when(repository.save(semiDeus)).thenReturn(semiDeus);

        ResponseEntity resposta = controller.atualizar(semiDeus);
        assertEquals(404, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());


    }
    @Test
    @DisplayName("verUmSemiDeus() retorna 200 se encontra alguem com id valido")
    void verUmSemiDeus(){
        Integer id = 2;
        SemiDeus semiDeus = Mockito.mock(SemiDeus.class);

        Mockito.when(repository.findById(id))
                .thenReturn(Optional.of(semiDeus));

        ResponseEntity resposta = controller.verUmSemiDeus(id);

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(semiDeus, resposta.getBody());

    }

    @Test
    @DisplayName("verUmSemiDeus() retorna 404 se não existir um SemiDeus com esse id")
    void verUmSemiDeus2(){
        Integer id = 51;
        Mockito.when(repository.findById(id))
                .thenReturn(Optional.empty());

        ResponseEntity resposta = controller.verUmSemiDeus(id);

        assertEquals(404, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }




}