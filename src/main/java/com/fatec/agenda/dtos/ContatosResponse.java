package com.fatec.agenda.dtos;

public record ContatosResponse(
   
    int id,
    String nome,
    String email,
    String telefone,
    String tipoContato,
    String preferenciaContato,
    String observacoes
) {
    
}
