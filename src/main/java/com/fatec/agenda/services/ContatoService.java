package com.fatec.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.agenda.dtos.ContatosRequest;
import com.fatec.agenda.dtos.ContatosResponse;
import com.fatec.agenda.entities.Contato;
import com.fatec.agenda.mappers.ContatosMapper;
import com.fatec.agenda.repositories.ContatosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatoService {
    
    @Autowired
    private ContatosRepository contatosRepository;

    public List<ContatosResponse> getContatos(){ // get todo mundo
        List<Contato> contatos = contatosRepository.findAll();
        return contatos.stream()
        .map(c -> ContatosMapper.toDTO(c))
        .collect(Collectors.toList());
    }

    public ContatosResponse getContatoById(int id){ // get by id pae
        Contato contato = contatosRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Contato não cadastrado")
        );
        return ContatosMapper.toDTO(contato);
    }

    public void deleteContatoById(int id){ // delete by id
        if (this.contatosRepository.existsById(id)) {
            this.contatosRepository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }

    public void updateContato(int id, ContatosRequest request){ // update da massa
        try{
            Contato aux = contatosRepository.getReferenceById(id);
            aux.setNome(request.nome());
            aux.setEmail(request.email());
            aux.setTelefone(request.telefone());
            aux.setTipoContato(request.tipoContato());
            aux.setPreferenciaContato(request.preferenciaContato());
            aux.setObservacoes(request.observacoes());
            this.contatosRepository.save(aux);

        } catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }

    public ContatosResponse saveContato(ContatosRequest request){
        Contato contato = ContatosMapper.toEntity(request);
        return ContatosMapper.toDTO(this.contatosRepository.save(contato));
    }


}
