package com.example.continuada3.controllers;

import com.example.continuada3.dominios.Humano;
import com.example.continuada3.dominios.SemiDeus;
import com.example.continuada3.repositorios.HumanoRepository;
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



@SpringBootTest(classes = HumanoController.class)
class HumanoControllerTest {

    @Autowired
    HumanoController controller;

    @MockBean
    HumanoRepository repository;

    @Test
    @DisplayName("verHumanos() deve trazer Humanos status 200")
    void getVerHumanos1() {

        List<Humano> humanos =
                Arrays.asList(Mockito.mock(Humano.class));

        Mockito.when(repository.findAll()).thenReturn(humanos);

        ResponseEntity resposta = controller.verHumanos();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(humanos, resposta.getBody());
    }

    @Test
    @DisplayName("verHumanos() deve dar Status 204 ao trazer humanos de um repositorio vazio ")
    void verHumanos2() {

        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = controller.verHumanos();

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
    @DisplayName("cadastrarHumano() status 201 caso cadastre")
    void cadastrarCenario1() {
        Humano humano =Mockito.mock(Humano.class);
        Mockito.when(repository.save(humano)).thenReturn(humano);

        ResponseEntity resposta = controller.cadastrarHumano(humano);

        assertEquals(201, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }
    @Test
    @DisplayName("atualizar() retorna 201 se conseguir alterar")
    void atualizar1(){
        Humano humano =Mockito.mock(Humano.class);
        Mockito.when(repository.save(humano)).thenReturn(humano);
        ResponseEntity resposta = controller.atualizar(humano);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());


    }
    @Test
    @DisplayName("atualizar() retorna 404 se não encontrar o usuario para  alterar")
    void atualizar2(){
        Integer id=2;
        Humano humano =Mockito.mock(Humano.class);
        Mockito.when(repository.existsById(id)).thenReturn(false);

        ResponseEntity resposta = controller.atualizar(humano);
        assertEquals(404, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());


    }

    @Test
    @DisplayName("verUmHumano() retorna 200 se encontra alguem com id valido")
    void verUmHumano(){
        Integer id = 2;
        Humano humano = Mockito.mock(Humano.class);

        Mockito.when(repository.findById(id))
                .thenReturn(Optional.of(humano));

        ResponseEntity resposta = controller.verUmHumano(id);

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(humano, resposta.getBody());

    }

    @Test
    @DisplayName("verUmHumano() retorna 404 se não existir um humano com esse id")
    void verUmHumano2(){
        Integer id = 51;
        Mockito.when(repository.findById(id))
                .thenReturn(Optional.empty());

        ResponseEntity resposta = controller.verUmHumano(id);

        assertEquals(404, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }


}