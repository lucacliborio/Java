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

import com.luca.projetofinal.model.Pedido;
import com.luca.projetofinal.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	private final PedidoService service;
	
	public PedidoController(PedidoService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<Pedido> listar() {
		return service.listarAll();
	}
	
	@GetMapping ("/{id}")
	public Pedido buscarId(@PathVariable Long id) {
		return service.buscarId(id);
	}
	
	@PostMapping
	public Pedido salvar(@RequestBody Pedido pedido) {
		return service.salvar(pedido);
	}
	
	@PutMapping("/{id}")
	public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
		return service.atualizar(id, pedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		 service.deletar(id);
	}
}
