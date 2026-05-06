package com.luca.projetofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.luca.projetofinal.model.ItemPedido;
import com.luca.projetofinal.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	private final ItemPedidoRepository repository;
	
	public ItemPedidoService(ItemPedidoRepository repository) {
		this.repository = repository;
	}
	
	public List<ItemPedido> listarAll(){
		return repository.findAll();
	}
	
	public ItemPedido buscarId(Long id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Item Pedido não encontrado"));
	}
	
	public ItemPedido salvar(ItemPedido itempedido) {
		return repository.save(itempedido);
	}
	
	public ItemPedido atualizar(Long id, ItemPedido itempedidoAtualizado) {
		ItemPedido itempedido = buscarId(id);
		
		itempedido.setPedido(itempedidoAtualizado.getPedido());
		itempedido.setProduto(itempedidoAtualizado.getProduto());
		itempedido.setQuantidade(itempedidoAtualizado.getQuantidade());
		itempedido.setPrecoUnitario(itempedidoAtualizado.getPrecoUnitario());
		
		return repository.save(itempedidoAtualizado);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
