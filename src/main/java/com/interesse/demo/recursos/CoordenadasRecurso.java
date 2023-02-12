package com.interesse.demo.recursos;

import com.interesse.demo.entidades.Coordenadas;
import com.interesse.demo.servicos.CoordenadasServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ponto-de-interesse")
public class CoordenadasRecurso {

    @Autowired
    private CoordenadasServico coordenadasServico;

    @GetMapping
    public ResponseEntity<List<Coordenadas>> findAll(){
        List<Coordenadas> lista = coordenadasServico.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Coordenadas> findById(@PathVariable Integer id){
        Coordenadas objeto = coordenadasServico.findById(id);
        return ResponseEntity.ok().body(objeto);
    }

    @RequestMapping(value="/nome/{nome}", method=RequestMethod.GET)
    public ResponseEntity<Coordenadas> findByNome(@PathVariable String nome){
        Coordenadas objeto = coordenadasServico.findByNome(nome);
        return ResponseEntity.ok().body(objeto);
    }
    /*
    @GetMapping(value = "/params/{$params}")
    public ResponseEntity<Optional<Coordenadas>> findByParams(@RequestBody Float coordenadaX, @RequestBody Float coordenadaY, @RequestBody Coordenadas destino){
       Optional<Coordenadas> objeto = coordenadasServico.findByParams(coordenadaX, coordenadaY, destino);
       return ResponseEntity.ok().body(objeto);
    }
    */
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Coordenadas> insert(@RequestBody Coordenadas objeto) {
        objeto = coordenadasServico.insert(objeto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(objeto.getId()).toUri();
        return ResponseEntity.created(uri).body(objeto);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        coordenadasServico.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Coordenadas> update(@PathVariable Integer id, @RequestBody Coordenadas objeto) {
        objeto = coordenadasServico.update(id, objeto);
        return ResponseEntity.ok().body(objeto);
    }

}
