package com.luca.projetofinal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.projetofinal.model.dto.CategoriaDTO;
import com.luca.projetofinal.model.dto.ClienteDTO;
import com.luca.projetofinal.model.dto.ItemPedidoDTO;
import com.luca.projetofinal.model.dto.PedidoDTO;
import com.luca.projetofinal.model.dto.ProdutoDTO;
import com.luca.projetofinal.model.entity.ItemPedido;
import com.luca.projetofinal.model.entity.Pedido;
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
	
	public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
	    Pedido pedido = buscarId(id);
	    pedido.setData(pedidoAtualizado.getData());
	    pedido.setCliente(pedidoAtualizado.getCliente());
	    pedido.getItens().clear();
	    for (ItemPedido item : pedidoAtualizado.getItens()) {
	        item.setPedido(pedido);
	        pedido.getItens().add(item);
	    }
	    return repository.findById(repository.save(pedido).getId()).get();
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}

	public PedidoDTO converterParaDTO(Pedido pedido) {
		ClienteDTO clienteDTO = new ClienteDTO(
			pedido.getCliente().getId(),
			pedido.getCliente().getNome(),
			pedido.getCliente().getEmail()
		);

		List<ItemPedidoDTO> itensDTO = pedido.getItens().stream().map(item -> {
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
		}).toList();

		return new PedidoDTO(pedido.getId(), pedido.getData(), clienteDTO, itensDTO);
	}
}
