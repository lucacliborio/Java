package com.fachiano.ensino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fachiano.ensino.model.Curso;
import com.fachiano.ensino.model.Professor;
import com.fachiano.ensino.repository.CursoRepository;
import com.fachiano.ensino.repository.ProfessorRepository;

@Service
public class CursoService {
	
	
	private final ProfessorRepository professorRepository;
	private final CursoRepository cursoRepository;

	public CursoService(ProfessorRepository professorRepository, CursoRepository cursoRepository) {
		this.professorRepository = professorRepository;
		this.cursoRepository = cursoRepository;
	}
	
	public List<Curso> listarTodos(){
		return cursoRepository.findAll();
	}
	
	public Curso salvar(Curso curso, Long professorId) {
		Professor professor = professorRepository.findById(professorId).orElseThrow(()-> new RuntimeException("Não existe professor com esse ID"));
		
		curso.setProfessor(professor);
		
		return cursoRepository.save(curso);
	}
	
}
