package com.fatec.agenda.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatosRequest(
    
    @NotBlank(message = "O nome precisa ser preenchido")
    @NotNull(message = "nome não pode ser nulo")
    String nome, 
    
    @NotBlank(message = "email precisa ser preenchido")
    String email,
    
    @NotBlank(message = "telefone precisa ser preenchido")
    String telefone,
    
    @NotBlank(message = "tipo precisa ser preenchido")
    String tipoContato,
    
    @NotBlank(message = "preferencia precisa ser preenchido")
    String preferenciaContato,
   
    @NotBlank(message = "observações precisa ser preenchida")
    String observacoes,
    
    Boolean confirmacao) {
    
}
