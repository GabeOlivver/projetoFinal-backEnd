package com.fatec.agenda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTATOS_TB")
public class Contato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 40, nullable = false)
    private String nome;
    private String email;
    private String telefone;
    private String tipoContato;
    private String preferenciaContato;
    private String observacoes;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTipoContato() {
        return tipoContato;
    }
    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }
    public String getPreferenciaContato() {
        return preferenciaContato;
    }
    public void setPreferenciaContato(String preferenciaContato) {
        this.preferenciaContato = preferenciaContato;
    }
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
