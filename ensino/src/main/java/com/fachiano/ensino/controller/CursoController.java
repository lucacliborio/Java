package com.fachiano.ensino.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fachiano.ensino.model.dto.CursoProfessorDTO;
import com.fachiano.ensino.model.entity.Curso;
import com.fachiano.ensino.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	private final CursoService cursoService;
	
	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	@GetMapping
	public List<Curso> listarTodos(){
		return cursoService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public CursoProfessorDTO listarPorId(@PathVariable Long id) {
		Curso curso = cursoService.listarPorId(id);
		return cursoService.converterDTO(curso);
	}
	
	@PostMapping("/{professorID}")
	public Curso salvar(@RequestBody Curso curso, @PathVariable Long professorID) {
		return cursoService.salvar(curso, professorID);
	}
	
	

}
