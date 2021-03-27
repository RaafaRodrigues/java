package com.projeto.continuada2.Controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/download")
public class DownloadController {

    @GetMapping(value = "/csv/{raca}", produces = "application/CSV")
    @ResponseBody
    public ResponseEntity baixarCsv(@PathVariable String raca) throws Exception {
        if( raca.equals("saiyajin")) {

                Path currentRelativePath = Paths.get("");
                String url = currentRelativePath.toAbsolutePath().toString() + "/saiyajin.csv";
                File downloadFile = new File(url);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition", "attachment;filename=saiyajin.csv");

               if(downloadFile.exists()) {
                    return new ResponseEntity(new FileSystemResource(downloadFile), headers, HttpStatus.OK);
                }else{
                    return ResponseEntity.badRequest().build();
                }
        }else if(raca.equals("namek")){

                Path currentRelativePath = Paths.get("");
                String url = currentRelativePath.toAbsolutePath().toString() + "/namek.csv";
                File downloadFile = new File(url);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition", "attachment;filename=namek.csv");
                if (downloadFile.exists()) {
                    return new ResponseEntity(new FileSystemResource(downloadFile), headers, HttpStatus.OK);
                }else {
                    return ResponseEntity.badRequest().build();
                }
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping(value = "/txt/{raca}", produces = "application/CSV")
    @ResponseBody
    public ResponseEntity baixarTxt(@PathVariable String raca) throws Exception {
        if(raca.equals("namek")){

            Path currentRelativePath = Paths.get("");
            String url = currentRelativePath.toAbsolutePath().toString() + "/namek.txt";
            File downloadFile = new File(url);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename=namek.txt");
            if (downloadFile.exists()) {
                return new ResponseEntity(new FileSystemResource(downloadFile), headers, HttpStatus.OK);
            }else {
                return ResponseEntity.badRequest().build();
            }
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
