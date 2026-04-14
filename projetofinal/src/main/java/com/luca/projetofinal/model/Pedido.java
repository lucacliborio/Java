package com.luca.projetofinal.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private LocalDate data;

	 @ManyToOne
	 @JoinColumn(name = "cliente_id")
	 private Cliente cliente;

	 @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	 @JsonManagedReference
	 private List<ItemPedido> itens;
	 
	public Pedido() {}

	public Pedido(Long id, LocalDate data, Cliente cliente, List<ItemPedido> itens) {
		super();
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.itens = itens;
	}

	// getters e setters
	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public LocalDate getData() {
		 return data;
	 }

	 public void setData(LocalDate data) {
		 this.data = data;
	 }

	 public Cliente getCliente() {
		 return cliente;
	 }

	 public void setCliente(Cliente cliente) {
		 this.cliente = cliente;
	 }

	 public List<ItemPedido> getItens() {
		 return itens;
	 }

	 public void setItens(List<ItemPedido> itens) {
		 this.itens = itens;
	 }
	 
}
