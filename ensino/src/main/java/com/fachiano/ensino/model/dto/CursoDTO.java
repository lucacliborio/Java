package com.fachiano.ensino.model.dto;

public class CursoDTO {

	private Long id;
	private String titulo;
	
	public CursoDTO(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	

}
