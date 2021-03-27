package com.projeto.continuada2.Controllers;
import com.projeto.continuada2.utils.ListaObj;
import com.projeto.continuada2.utils.MetodoCriarLer;
import com.projeto.continuada2.dominios.Saiyajin;
import com.projeto.continuada2.repositorios.SaiyajinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/saiyajins")
public class SaiyajinController {

    ListaObj<Saiyajin> saiyajinList;


    @Autowired
    private SaiyajinRepository repositorioSaiyajin;


    @PostMapping
    public ResponseEntity salvar(@RequestBody Saiyajin novoSaiyajin) {
        repositorioSaiyajin.save(novoSaiyajin);
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity todosSaiyajin() {
        return repositorioSaiyajin.count() > 0 ?
                ResponseEntity.ok(repositorioSaiyajin.findAll()) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Integer id, @RequestBody Saiyajin attSaiyajin) {
        if (repositorioSaiyajin.existsById(id)) {
            Saiyajin update = repositorioSaiyajin.getOne(id);
            update.setNome(attSaiyajin.getNome());
            update.setNivelTransformacao(attSaiyajin.getNivelTransformacao());
            update.setUniverso(attSaiyajin.getUniverso());
            repositorioSaiyajin.save(update);
            return ResponseEntity.ok().build();
        } else {

            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        if (repositorioSaiyajin.existsById(id)) {
            repositorioSaiyajin.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/gerar/csv")
    public void preencherCsv() {
        MetodoCriarLer m = new MetodoCriarLer();
        saiyajinList = new ListaObj(repositorioSaiyajin.findAll().size());
        for (Integer i = 0; !saiyajinList.listaCheia(); i++) {
            Saiyajin s = repositorioSaiyajin.findAll().get(i);

            saiyajinList.adiciona(s);
        }
        m.gerarCsvSaiyajin(saiyajinList);
        saiyajinList.limpa();
    }

    @GetMapping("/ler/csv")
    public void lerCsv(Boolean isSaiyajin) {
        MetodoCriarLer m =new MetodoCriarLer();
        m.lerArquivoCsv(true);

    }


}

