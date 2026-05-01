package com.fachiano.ensino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fachiano.ensino.model.dto.CursoProfessorDTO;
import com.fachiano.ensino.model.dto.ProfessorDTO;
import com.fachiano.ensino.model.entity.Curso;
import com.fachiano.ensino.model.entity.Professor;
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
	
	public Curso listarPorId(Long id) {
		return cursoRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Curso nÃ£o encontrado"));
	}
	
	public Curso salvar(Curso curso, Long professorId) {
		Professor professor = professorRepository.findById(professorId).orElseThrow(()-> new RuntimeException("Não existe professor com esse ID"));
		
		curso.setProfessor(professor);
		
		return cursoRepository.save(curso);
	}
	
	public CursoProfessorDTO converterDTO(Curso curso) {
		Professor professor = curso.getProfessor();

		ProfessorDTO professorDTO = new ProfessorDTO(
			professor.getId(),
			professor.getNome(),
			professor.getEspecialidade()
		);
					
		return new CursoProfessorDTO(curso.getId(), curso.getTitulo(), professorDTO);
	}
	
}
