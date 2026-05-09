package com.luca.projetofinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.luca.projetofinal.model.dto.CategoriaDTO;
import com.luca.projetofinal.model.entity.Categoria;
import com.luca.projetofinal.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriController {
	
	private final CategoriaService service;
	
	public CategoriController(CategoriaService service) {
		this.service = service;
	}

	@GetMapping
	public List<Categoria> listar() {
		return service.listarAll();
	}
	
	@GetMapping("/{id}")
	public CategoriaDTO buscarId(@PathVariable Long id) {
		Categoria categoria = service.buscarId(id);
		return service.converterParaDTO(categoria);
	}
	
	@PostMapping
	public Categoria salvar(@RequestBody Categoria categoria) {
		return service.salvar(categoria);
	}
	
	@PutMapping("/{id}")
	public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
		return service.atualizar(id, categoria);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}
