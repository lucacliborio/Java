package com.luca.projetofinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.luca.projetofinal.model.dto.ClienteDTO;
import com.luca.projetofinal.model.entity.Cliente;
import com.luca.projetofinal.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private final ClienteService service;
	
	public ClienteController(ClienteService service) {
		this.service = service;
	}

	@GetMapping
	public List<Cliente> listar() {
		return service.listarAll();
	}
	
	@GetMapping("/{id}")
	public ClienteDTO buscarId(@PathVariable Long id) {
		Cliente cliente = service.buscarId(id);
		return service.converterParaDTO(cliente);
	}
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return service.salvar(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return service.atualizar(id, cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}
