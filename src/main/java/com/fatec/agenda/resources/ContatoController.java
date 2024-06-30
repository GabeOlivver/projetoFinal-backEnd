package com.fatec.agenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.agenda.dtos.ContatosRequest;
import com.fatec.agenda.dtos.ContatosResponse;
import com.fatec.agenda.entities.Contato;
import com.fatec.agenda.services.ContatoService;

@RestController
@RequestMapping("agenda")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<ContatosResponse> getContatos(){
        return contatoService.getContatos();
    }
    @GetMapping("/{id}")
    public ContatosResponse getContatoById(@PathVariable int id){
        return contatoService.getContatoById(id);
    }
    @DeleteMapping("{id}")
    public void deleteContatoById(@PathVariable int id){
        this.contatoService.deleteContatoById(id);
    }
    @PostMapping
    public ContatosResponse saveContato(@RequestBody ContatosRequest contato){
        return contatoService.saveContato(contato);
    }
    @PutMapping("{id}")
    public void updateContato(@PathVariable int id,@RequestBody ContatosRequest contato){
        this.contatoService.updateContato(id, contato);
    }
}
