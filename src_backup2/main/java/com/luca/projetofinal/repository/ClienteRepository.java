package com.luca.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luca.projetofinal.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
