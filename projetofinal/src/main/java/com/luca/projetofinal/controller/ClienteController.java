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

import com.luca.projetofinal.model.Cliente;
import com.luca.projetofinal.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private final ClienteService service;
	
	public ClienteController(ClienteService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<Cliente> listar() {
		return service.listarAll();
	}
	
	@GetMapping ("/{id}")
	public Cliente buscarId(@PathVariable Long id) {
		return service.buscarId(id);
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
