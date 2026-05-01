package com.fachiano.ensino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fachiano.ensino.model.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
