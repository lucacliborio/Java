package com.luca.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luca.projetofinal.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
