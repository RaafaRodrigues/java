package com.example.continuada3.controllers;

import com.example.continuada3.dominios.Deus;
import com.example.continuada3.repositorios.DeusRespository;
import com.example.continuada3.utils.FilaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@RestController
@RequestMapping("/arquivos")
public class ArquivoController {
    private FilaObj<UUID> filaReq = new FilaObj<>(100);
    private List<UUID> tratados = new ArrayList<>();
    private Map<UUID, List<Deus>> resultados = new HashMap<>();


    @Autowired
        private DeusRespository deusService;


    @PostMapping("/import")
    public ResponseEntity importDocument(@RequestParam("Deus") MultipartFile arquivo) throws IOException {
        if (arquivo.isEmpty()) {
            return ResponseEntity.badRequest().body("arquivo não enviado");
        }
        UUID identificador = UUID.randomUUID();
        System.out.println("Recebendo arquivo do tipo " + arquivo.getContentType());

        byte[] conteudo = arquivo.getBytes();

        Path path = Paths.get(arquivo.getOriginalFilename());
        Files.write(path, conteudo);
        BufferedReader entrada = null;
        String registro;
        String tipoRegistro;
        String nome, panteao;
        try {
            entrada = new BufferedReader(new FileReader(arquivo.getOriginalFilename()));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        List<Deus> deus = new ArrayList<>();

        try {
            registro = entrada.readLine();
            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("02")) {
                    nome = registro.substring(2, 40).trim();
                    panteao = registro.substring(40,55).trim();
                    Deus deuses = new Deus();
                    deuses.setNome(nome);
                    deuses.setPanteao(panteao);
                    deus.add(deuses);
                }
                registro = entrada.readLine();
            }
            entrada.close();
        } catch (IOException e) {
            System.err.printf("Erro ao ler arquivo: %s.\n", e.getMessage());
        }
        resultados.put(identificador, deus);
        filaReq.insert(identificador);

        Integer espera=(filaReq.tamanhoAtual()*2);
        return ResponseEntity.accepted().header("identificador", identificador.toString()).header("Tempo estimado em Minutos",espera.toString()).build();
    }

    @Scheduled(fixedRate = 120000)
    public void tratarRequesicao() {
        if (!filaReq.isEmpty()) {
            List<Deus> d = resultados.get(filaReq.peek());
            for (Deus deus : d) {
                deusService.save(deus);
            }
            resultados.remove(filaReq.peek());
            tratados.add(filaReq.poll());

        }
    }

    @GetMapping("/resultado/{identificador}")
    public ResponseEntity resultadoDelete(@PathVariable UUID identificador) {
        for (Integer i = 0; i < tratados.size(); i++) {
            if (tratados.get(i).equals(identificador)) {
                tratados.remove(i);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.noContent().build();
    }

}

