package com.luca.projetofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.projetofinal.model.dto.CategoriaDTO;
import com.luca.projetofinal.model.dto.ItemPedidoDTO;
import com.luca.projetofinal.model.dto.ProdutoDTO;
import com.luca.projetofinal.model.entity.ItemPedido;
import com.luca.projetofinal.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	private final ItemPedidoRepository repository;

	public ItemPedidoService(ItemPedidoRepository repository) {
		this.repository = repository;
	}

	public List<ItemPedido> listarAll() {
		return repository.findAll();
	}

	public ItemPedido buscarId(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("ItemPedido não encontrado"));
	}

	public ItemPedido salvar(ItemPedido itemPedido) {
		return repository.save(itemPedido);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}

	public ItemPedidoDTO converterParaDTO(ItemPedido item) {
		CategoriaDTO categoriaDTO = new CategoriaDTO(
			item.getProduto().getCategoria().getId(),
			item.getProduto().getCategoria().getNome(),
			item.getProduto().getCategoria().getDescricao()
		);
		ProdutoDTO produtoDTO = new ProdutoDTO(
			item.getProduto().getId(),
			item.getProduto().getNome(),
			item.getProduto().getPreco(),
			categoriaDTO
		);
		return new ItemPedidoDTO(item.getId(), produtoDTO, item.getQuantidade(), item.getPrecoUnitario());
	}
}
