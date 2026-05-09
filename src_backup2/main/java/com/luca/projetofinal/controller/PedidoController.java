package com.luca.projetofinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.luca.projetofinal.model.dto.PedidoDTO;
import com.luca.projetofinal.model.entity.Pedido;
import com.luca.projetofinal.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	private final PedidoService service;
	
	public PedidoController(PedidoService service) {
		this.service = service;
	}

	@GetMapping
	public List<Pedido> listar() {
		return service.listarAll();
	}
	
	@GetMapping("/{id}")
	public PedidoDTO buscarId(@PathVariable Long id) {
		Pedido pedido = service.buscarId(id);
		return service.converterParaDTO(pedido);
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
