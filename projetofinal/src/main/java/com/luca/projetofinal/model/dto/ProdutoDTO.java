package com.luca.projetofinal.model.dto;

public class ProdutoDTO {

	private Long id;
	private String nome;
	private Double preco;
	private CategoriaDTO categoria;

	public ProdutoDTO(Long id, String nome, Double preco, CategoriaDTO categoria) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}
}
