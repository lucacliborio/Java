package com.luca.projetofinal.model.dto;

import java.time.LocalDate;
import java.util.List;

public class PedidoDTO {

	private Long id;
	private LocalDate data;
	private ClienteDTO cliente;
	private List<ItemPedidoDTO> itens;

	public PedidoDTO(Long id, LocalDate data, ClienteDTO cliente, List<ItemPedidoDTO> itens) {
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public List<ItemPedidoDTO> getItens() {
		return itens;
	}
}
