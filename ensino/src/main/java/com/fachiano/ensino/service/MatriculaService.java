package com.fachiano.ensino.service;

import org.springframework.stereotype.Service;

import com.fachiano.ensino.model.entity.Aluno;
import com.fachiano.ensino.model.entity.Curso;
import com.fachiano.ensino.repository.AlunoRepository;
import com.fachiano.ensino.repository.CursoRepository;

@Service
public class MatriculaService {

	private final AlunoRepository alunorepository;
	private final CursoRepository cursorepository;

	public MatriculaService(AlunoRepository alunorepository, CursoRepository cursorepository) {
		this.alunorepository = alunorepository;
		this.cursorepository = cursorepository;
	}
	
	public Aluno matricular(Long alunoId, Long cursoId) {
		Aluno aluno =  alunorepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));
		Curso curso = cursorepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
		
		aluno.getCursos().add(curso);
		
		return alunorepository.save(aluno);
	}
	
}
