package com.fatec.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.agenda.entities.Contato;

public interface ContatosRepository extends JpaRepository <Contato,Integer> {}
