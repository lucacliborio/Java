package com.luca.projetofinal.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  private String nome;
	  private String descricao;
	  
	  @OneToMany(mappedBy = "categoria")
	  private List<Produto> produtos;
	  
	  public Categoria() {}
	  
	  public Categoria(Long id, String nome, String descricao, List<Produto> produtos) {
			super();
			this.id = id;
			this.nome = nome;
			this.descricao = descricao;
			this.produtos = produtos;
		}

	  
	// getters e setters
	  public Long getId() {
		  return id;
	  }

	  public void setId(Long id) {
		  this.id = id;
	  }

	  public String getNome() {
		  return nome;
	  }

	  public void setNome(String nome) {
		  this.nome = nome;
	  }

	  public String getDescricao() {
		  return descricao;
	  }

	  public void setDescricao(String descricao) {
		  this.descricao = descricao;
	  }

	  public List<Produto> getProdutos() {
		  return produtos;
	  }

	  public void setProdutos(List<Produto> produtos) {
		  this.produtos = produtos;
	  }

	    
}
