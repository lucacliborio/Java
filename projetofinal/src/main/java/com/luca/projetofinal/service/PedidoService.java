package com.luca.projetofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.projetofinal.model.Pedido;
import com.luca.projetofinal.repository.PedidoRepository;


@Service
public class PedidoService {
	
	private final PedidoRepository repository;
	
	public PedidoService(PedidoRepository repository) {
		this.repository = repository;
	}
	
	public List<Pedido> listarAll(){
		return repository.findAll();
	}
	
	public Pedido buscarId(Long id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Pedido não encontrado"));
	}
	
	public Pedido salvar(Pedido pedido) {
		return repository.save(pedido);
	}
	
	public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
		Pedido pedido = buscarId(id);
		
		pedido.setData(pedidoAtualizado.getData());
		pedido.setCliente(pedidoAtualizado.getCliente());
		pedido.setItens(pedidoAtualizado.getItens());
		
		return repository.save(pedido);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
