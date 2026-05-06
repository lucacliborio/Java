package com.luca.projetofinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.luca.projetofinal.model.dto.ItemPedidoDTO;
import com.luca.projetofinal.model.entity.ItemPedido;
import com.luca.projetofinal.service.ItemPedidoService;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {
	
	private final ItemPedidoService service;
	
	public ItemPedidoController(ItemPedidoService service) {
		this.service = service;
	}

	@GetMapping
	public List<ItemPedido> listar() {
		return service.listarAll();
	}
	
	@GetMapping("/{id}")
	public ItemPedidoDTO buscarId(@PathVariable Long id) {
		ItemPedido item = service.buscarId(id);
		return service.converterParaDTO(item);
	}
	
	@PostMapping
	public ItemPedido salvar(@RequestBody ItemPedido itemPedido) {
		return service.salvar(itemPedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}
