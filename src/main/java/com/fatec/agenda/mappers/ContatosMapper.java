package com.fatec.agenda.mappers;

import com.fatec.agenda.dtos.ContatosRequest;
import com.fatec.agenda.dtos.ContatosResponse;
import com.fatec.agenda.entities.Contato;

public class ContatosMapper {
    public static Contato toEntity(ContatosRequest request){
        Contato contato = new Contato();
        contato.setNome(request.nome());
        contato.setEmail(request.email());
        contato.setTelefone(request.telefone());
        contato.setTipoContato(request.tipoContato());
        contato.setPreferenciaContato(request.preferenciaContato());
        contato.setObservacoes(request.observacoes());

        return contato;
    }

    public static ContatosResponse toDTO(Contato contato){
        return new ContatosResponse(
        contato.getId(), 
        contato.getNome(),
        contato.getEmail(),
        contato.getTelefone(),
        contato.getTipoContato(),
        contato.getPreferenciaContato(),
        contato.getObservacoes());
    }
}
