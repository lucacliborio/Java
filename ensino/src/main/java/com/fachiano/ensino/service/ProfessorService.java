package com.fachiano.ensino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fachiano.ensino.model.Professor;
import com.fachiano.ensino.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	private ProfessorRepository professorRepository;
	
	public ProfessorService(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}
	
	public List<Professor> listarTodos(){
		return professorRepository.findAll();
	}
	
	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}
}
