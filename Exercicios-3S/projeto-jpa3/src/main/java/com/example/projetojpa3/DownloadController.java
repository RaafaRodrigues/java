package com.example.projetojpa3;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class DownloadController {


   @GetMapping("/um")
    public ResponseEntity getOne(){
        return ResponseEntity.ok(1);
    }
    @GetMapping(value="/imagem-loka" ,produces="image/jpeg")
    @ResponseBody
    public ResponseEntity getImage(){
       return ResponseEntity.ok("Só que não!");
    }
    @GetMapping(value = "/zip-loko",produces = "application/x-7z-compressed")
    @ResponseBody
    public ResponseEntity getZip(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Disposition","attachment; filename=lokao.zip");
        return new ResponseEntity("Conteudo do Zip fake",headers, HttpStatus.OK);
    }
}
