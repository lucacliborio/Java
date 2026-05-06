package com.luca.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luca.projetofinal.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
