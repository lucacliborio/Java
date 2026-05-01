package com.fachiano.ensino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fachiano.ensino.model.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
