package com.luca.projetofinal.model.dto;

public class ItemPedidoDTO {

	private Long id;
	private ProdutoDTO produto;
	private Integer quantidade;
	private Double precoUnitario;

	public ItemPedidoDTO(Long id, ProdutoDTO produto, Integer quantidade, Double precoUnitario) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}

	public Long getId() {
		return id;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}
}
