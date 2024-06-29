package com.fatec.agenda.dtos;

public record ContatosRequest(
    String nome, 
    String email,
    String telefone,
    String tipoContato,
    String preferenciaContato,
    String observacoes) {
    
}
