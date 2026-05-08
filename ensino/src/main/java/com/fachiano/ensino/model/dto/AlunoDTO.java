package com.fachiano.ensino.model.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AlunoDTO {

	private Long id;
	@NotBlank(message = "Nome é obrigatorio")
	private String nome;
	@NotBlank(message = "Email é obrigatorio")
	@Email(message = "Email Com formato inválido")
	private String email;
	private List<CursoDTO> cursos;
	
	public AlunoDTO(Long id, String nome, String email, List<CursoDTO> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cursos = cursos;
	}

	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public List<CursoDTO> getCursos() {
		return cursos;
	}

	
	
	
}
