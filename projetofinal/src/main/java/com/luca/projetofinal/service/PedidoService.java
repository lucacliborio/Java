package com.luca.projetofinal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.projetofinal.model.ItemPedido;
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

	    pedido.setData(LocalDate.now());

	    for (ItemPedido item : pedido.getItens()) {
	        item.setPedido(pedido);
	    }

	    return repository.save(pedido);
	}
	
	/*public Pedido atualizar(Long id, Pedido pedidoAtualizado) {

	    Pedido pedido = buscarId(id);

	    pedido.setData(pedidoAtualizado.getData());
	    pedido.setCliente(pedidoAtualizado.getCliente());

	    List<ItemPedido> itensAtuais = pedido.getItens();

	    List<ItemPedido> itensAtualizados = pedidoAtualizado.getItens();

	    for (ItemPedido itemAtualizado : itensAtualizados) {

	        if (itemAtualizado.getId() != null) {
	            ItemPedido existente = itensAtuais.stream()
	                .filter(i -> i.getId().equals(itemAtualizado.getId()))
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

	            existente.setQuantidade(itemAtualizado.getQuantidade());
	            existente.setPrecoUnitario(itemAtualizado.getPrecoUnitario());
	            existente.setProduto(itemAtualizado.getProduto());

	        } else {
	            itemAtualizado.setPedido(pedido);
	            itensAtuais.add(itemAtualizado);
	        }
	    }

	    itensAtuais.removeIf(itemExistente ->
	        itensAtualizados.stream()
	            .noneMatch(itemAtualizado ->
	                itemAtualizado.getId() != null &&
	                itemAtualizado.getId().equals(itemExistente.getId())
	            )
	    );

	    return repository.save(pedido);
	}*/
	
	public Pedido atualizar(Long id, Pedido pedidoAtualizado) {

	    Pedido pedido = buscarId(id);

	    pedido.setData(pedidoAtualizado.getData());
	    pedido.setCliente(pedidoAtualizado.getCliente());

	    pedido.getItens().clear();

	    for (ItemPedido item : pedidoAtualizado.getItens()) {
	        item.setPedido(pedido);
	        pedido.getItens().add(item);
	    }

	    Pedido salvo = repository.save(pedido);

	    return repository.findById(salvo.getId()).get();
	}
	
	
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
