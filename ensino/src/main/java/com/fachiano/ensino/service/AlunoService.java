package com.fachiano.ensino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fachiano.ensino.model.dto.AlunoDTO;
import com.fachiano.ensino.model.dto.CursoDTO;
import com.fachiano.ensino.model.entity.Aluno;
import com.fachiano.ensino.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
	
	
	private final AlunoRepository repository;
	
	public AlunoService(AlunoRepository repository) {
		this.repository = repository;
	}
	
	public List<Aluno> listarTodos(){
		return repository.findAll();
	}
	
	public Aluno buscarPorId(Long id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Aluno não encontrado"));
	}
	
	public Aluno salvar(Aluno aluno) {
		return repository.save(aluno);
	}
	
	public Aluno atualizar(Long id, Aluno alunoAtualizado) {
		Aluno aluno = buscarPorId(id);
		
		aluno.setNome(alunoAtualizado.getNome());
		aluno.setEmail(alunoAtualizado.getEmail());
		
		return repository.save(aluno);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
	public AlunoDTO converterParaDTO(Aluno aluno) {
		List<CursoDTO> cursosDTO = aluno.getCursos().stream().map(curso -> new CursoDTO(curso.getId(), curso.getTitulo())).toList();
		
		return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), cursosDTO);
	}

}
