package com.fachiano.ensino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fachiano.ensino.model.dto.CursoDTO;
import com.fachiano.ensino.model.dto.ProfessorCursoDTO;
import com.fachiano.ensino.model.entity.Professor;
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
	
	public Professor listarPorId(Long Id) {
		return professorRepository.findById(Id)
				.orElseThrow(()-> new RuntimeException("Professor nÃ£o encontrado"));
	}
	
	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public ProfessorCursoDTO converterDTO(Professor professor) {
		List<CursoDTO> cursoDTO = professor.getCursos().stream()
									.map(
										curso -> new CursoDTO(curso.getId(), curso.getTitulo())
										)
									.toList();
									
		return new ProfessorCursoDTO(professor.getId(), professor.getNome(), professor.getEspecialidade(), cursoDTO);
	}
}
