package com.luca.projetofinal.model.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate data;

	@NotNull(message = "Cliente é obrigatório")
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@NotEmpty(message = "O pedido deve ter pelo menos um item")
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JsonManagedReference
	private List<ItemPedido> itens;

	public Pedido() {}

	public Pedido(Long id, LocalDate data, Cliente cliente, List<ItemPedido> itens) {
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.itens = itens;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public LocalDate getData() { return data; }
	public void setData(LocalDate data) { this.data = data; }

	public Cliente getCliente() { return cliente; }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }

	public List<ItemPedido> getItens() { return itens; }
	public void setItens(List<ItemPedido> itens) { this.itens = itens; }
}

	/*{
	  "cliente": {
	    "id": 1
	  },
	  "itens": [
	    {
	      "produto": { "id": 1 },
	      "quantidade": 2,
	      "precoUnitario": 89.90
	    }
	  ]
	}*/
