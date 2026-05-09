package com.luca.projetofinal.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	@JsonBackReference
	private Pedido pedido;

	@NotNull(message = "Produto é obrigatório")
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@NotNull(message = "Quantidade é obrigatória")
	@Positive(message = "Quantidade deve ser maior que zero")
	private Integer quantidade;

	@NotNull(message = "Preço unitário é obrigatório")
	@PositiveOrZero(message = "Preço unitário não pode ser negativo")
	private Double precoUnitario;

	public ItemPedido() {}

	public ItemPedido(Long id, Pedido pedido, Produto produto, Integer quantidade, Double precoUnitario) {
		this.id = id;
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Pedido getPedido() { return pedido; }
	public void setPedido(Pedido pedido) { this.pedido = pedido; }

	public Produto getProduto() { return produto; }
	public void setProduto(Produto produto) { this.produto = produto; }

	public Integer getQuantidade() { return quantidade; }
	public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

	public Double getPrecoUnitario() { return precoUnitario; }
	public void setPrecoUnitario(Double precoUnitario) { this.precoUnitario = precoUnitario; }
}
