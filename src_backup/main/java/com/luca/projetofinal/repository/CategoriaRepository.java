package com.luca.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luca.projetofinal.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
