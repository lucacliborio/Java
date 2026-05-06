package com.luca.projetofinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.projetofinal.model.ItemPedido;
import com.luca.projetofinal.service.ItemPedidoService;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {
	
	private final ItemPedidoService service;
	
	public ItemPedidoController(ItemPedidoService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<ItemPedido> listar() {
		return service.listarAll();
	}
	
	@GetMapping ("/{id}")
	public ItemPedido buscarId(@PathVariable Long id) {
		return service.buscarId(id);
	}
	
	@PostMapping
	public ItemPedido salvar(@RequestBody ItemPedido itempedido) {
		return service.salvar(itempedido);
	}
	
	@PutMapping("/{id}")
	public ItemPedido atualizar(@PathVariable Long id, @RequestBody ItemPedido itempedido) {
		return service.atualizar(id, itempedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		 service.deletar(id);
	}
}
