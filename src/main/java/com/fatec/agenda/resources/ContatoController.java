package com.fatec.agenda.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.agenda.dtos.ContatosRequest;
import com.fatec.agenda.dtos.ContatosResponse;
import com.fatec.agenda.services.ContatoService;

@RestController
@RequestMapping("agenda")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<ContatosResponse>> getContatos(){
        return ResponseEntity.ok(contatoService.getContatos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContatosResponse> getContatoById(@PathVariable int id){
        return ResponseEntity.ok(contatoService.getContatoById(id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContatoById(@PathVariable int id){
        this.contatoService.deleteContatoById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<ContatosResponse> saveContato(@Validated @RequestBody ContatosRequest contato){
        ContatosResponse newContato = this.contatoService.saveContato(contato);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(newContato.id())
        .toUri();

        return ResponseEntity.created(location).body(newContato);
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updateContato(@PathVariable int id, @Validated @RequestBody ContatosRequest contato){
        this.contatoService.updateContato(id, contato);

        return ResponseEntity.ok().build();
    }
}
