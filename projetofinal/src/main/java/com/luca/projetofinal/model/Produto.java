package com.luca.projetofinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	public String nome;
	public String preco;
	
	public Produto() {}
	
	public Produto(Long id, String nome, String preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		
	}
	
	// getters e setters
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public String getPreco() {
		return preco;
	}
	
	
	
	
	
	
	
}
