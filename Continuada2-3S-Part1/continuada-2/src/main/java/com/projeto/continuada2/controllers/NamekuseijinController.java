package com.projeto.continuada2.Controllers;

import com.projeto.continuada2.utils.ListaObj;
import com.projeto.continuada2.utils.MetodoCriarLer;
import com.projeto.continuada2.dominios.Namekuseijin;
import com.projeto.continuada2.repositorios.NamekuseijinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/namekuseijin")
public class NamekuseijinController {
    ListaObj<Namekuseijin> listaNamek;

    @Autowired
    private NamekuseijinRepository repositorioNamekuseijin;


    @PostMapping
    public ResponseEntity cadastrar(@RequestBody Namekuseijin novoNamek){
        repositorioNamekuseijin.save(novoNamek);
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity todos(){
        return repositorioNamekuseijin.count()>0 ?
                ResponseEntity.ok(repositorioNamekuseijin.findAll()):
                ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Integer id, @RequestBody Namekuseijin attNamek) {
        if (repositorioNamekuseijin.existsById(id)) {
            Namekuseijin update = repositorioNamekuseijin.getOne(id);
            update.setNome(attNamek.getNome());
            update.setRegeneracao(attNamek.getRegeneracao());
            update.setUniverso(attNamek.getUniverso());
            repositorioNamekuseijin.save(update);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        if (repositorioNamekuseijin.existsById(id)) {
            repositorioNamekuseijin.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/gerar/csv")
    public void preencherCsv() {
        MetodoCriarLer m =new  MetodoCriarLer();
        listaNamek = new ListaObj(repositorioNamekuseijin.findAll().size());
        for (Integer i = 0; !listaNamek.listaCheia(); i++) {
            Namekuseijin n = repositorioNamekuseijin.findAll().get(i);

            listaNamek.adiciona(n);
        }
        m.gerarCsvNamek(listaNamek);
        listaNamek.limpa();
    }

    @GetMapping("/gerar/txt")
    public void preencerTxt(){
        MetodoCriarLer m =new  MetodoCriarLer();
        listaNamek = new ListaObj(repositorioNamekuseijin.findAll().size());
        for (Integer i = 0; !listaNamek.listaCheia(); i++) {
            Namekuseijin n = repositorioNamekuseijin.findAll().get(i);

            listaNamek.adiciona(n);
        }
        m.gerarTxtLayoutNamek(listaNamek);
        listaNamek.limpa();

    }

    @GetMapping("/ler/csv")
    public void lerCsv() {
        MetodoCriarLer m = new MetodoCriarLer();
        m.lerArquivoCsv(false);
    }

}
