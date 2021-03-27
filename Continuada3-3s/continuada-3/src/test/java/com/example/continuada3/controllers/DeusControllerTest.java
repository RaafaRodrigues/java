package com.example.continuada3.controllers;

import com.example.continuada3.dominios.Deus;
import com.example.continuada3.dominios.Humano;
import com.example.continuada3.repositorios.DeusRespository;
import com.example.continuada3.repositorios.HumanoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = DeusController.class)
class DeusControllerTest {
    @Autowired
    DeusController controller;

    @MockBean
    DeusRespository repository;

    @Test
    @DisplayName("verDeuses() deve trazer Deuses status 200")
    void getVerDeuses1() {

        List<Deus> deuses =
                Arrays.asList(Mockito.mock(Deus.class));

        Mockito.when(repository.findAll()).thenReturn(deuses);

        ResponseEntity resposta = controller.verDeuses();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(deuses, resposta.getBody());
    }

    @Test
    @DisplayName("verDeuses() deve dar Status 204 ao trazer humanos de um repositorio vazio ")
    void verDeuses2() {

        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = controller.verDeuses();

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
    @DisplayName("cadastrarDeus() status 201 caso cadastre")
    void cadastrarCenario1() {
        Deus deus =Mockito.mock(Deus.class);
        Mockito.when(repository.save(deus)).thenReturn(deus);

        ResponseEntity resposta = controller.cadastrarDeus(deus);

        assertEquals(201, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }

    @Test
    @DisplayName("atualizar() retorna 201 se conseguir alterar")
    void atualizar1(){
        Deus deus =Mockito.mock(Deus.class);
        Mockito.when(repository.save(deus)).thenReturn(deus);

        ResponseEntity resposta = controller.atualizar(deus);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());


    }
    @Test
    @DisplayName("verUmDeus() retorna 200 se encontra alguem com id valido")
    void verUmDeus(){
        Integer id = 2;
        Deus deus = Mockito.mock(Deus.class);

        Mockito.when(repository.findById(id))
                .thenReturn(Optional.of(deus));

        ResponseEntity resposta = controller.verUmDeus(id);

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(deus, resposta.getBody());

    }

    @Test
    @DisplayName("verUmDeus() retorna 404 se não existir um deus com esse id")
    void verUmDeus2(){
        Integer id = 51;
        Mockito.when(repository.findById(id))
                .thenReturn(Optional.empty());

        ResponseEntity resposta = controller.verUmDeus(id);

        assertEquals(404, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }

    @Test
    @DisplayName("atualizar() retorna 404 se não encontrar o usuario para  alterar")
    void atualizar2(){
        Deus deus =Mockito.mock(Deus.class);
        Mockito.when(repository.save(deus)).thenReturn(deus);

        ResponseEntity resposta = controller.atualizar(deus);
        assertEquals(404, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());


    }


}