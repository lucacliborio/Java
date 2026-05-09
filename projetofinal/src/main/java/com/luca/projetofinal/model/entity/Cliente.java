package com.luca.projetofinal.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@NotBlank(message = "Email é obrigatório")
	@Email(message = "Email com formato inválido")
	private String email;

	@NotBlank(message = "Senha é obrigatória")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String senha;

	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<Pedido> pedidos;

	public Cliente() {}

	public Cliente(Long id, String nome, String email, List<Pedido> pedidos, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.pedidos = pedidos;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getSenha() { return senha; }
	public void setSenha(String senha) { this.senha = senha; }

	public List<Pedido> getPedidos() { return pedidos; }
	public void setPedidos(List<Pedido> pedidos) { this.pedidos = pedidos; }
}


		/*{
		  "nome": "João Silva",
		  "email": "joao@email.com",
		  "senha": "123456"
		 }*?*/
