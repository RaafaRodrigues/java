package com.example.continuada3.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ArquivoControllerTest {


    @Test
    @DisplayName("resultadoDelete() retorna status 204 para uma requisição que não foi tratada")
    void resultadoDelete() {
        ArquivoController arq= new ArquivoController();
        UUID identificador = UUID.randomUUID();
        ResponseEntity resposta = arq.resultadoDelete(identificador);
        assertEquals(204, resposta.getStatusCodeValue());
        assertEquals(null, resposta.getBody());
    }


}