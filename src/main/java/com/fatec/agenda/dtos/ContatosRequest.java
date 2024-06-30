package com.fatec.agenda.dtos;

import jakarta.validation.constraints.NotNull;

public record ContatosRequest(
    @NotNull(message = "nome não pode ser nulo")
    String nome, 
    @NotNull(message = "email não pode ser nulo")
    String email,
    @NotNull(message = "telefone não pode ser nulo")
    String telefone,
    @NotNull(message = "tipo não pode ser nulo")
    String tipoContato,
    @NotNull(message = "preferencia não pode ser nulo")
    String preferenciaContato,
    @NotNull(message = "observações não pode ser nulo")
    String observacoes) {
    
}
