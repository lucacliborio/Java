package com.luca.projetofinal.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@NotNull(message = "Preço é obrigatório")
	@Positive(message = "Preço deve ser maior que zero")
	private Double preco;

	@NotNull(message = "Categoria é obrigatória")
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Produto() {}

	public Produto(Long id, String nome, Double preco, Categoria categoria) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public Double getPreco() { return preco; }
	public void setPreco(Double preco) { this.preco = preco; }

	public Categoria getCategoria() { return categoria; }
	public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}

	/* {
	  "nome": "Calça Jeans",
	  "preco": 89.90,
	  "categoria": {
	    "id": 1
	  }
	}*/
