package com.luca.projetofinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.luca.projetofinal.model.dto.ProdutoDTO;
import com.luca.projetofinal.model.entity.Produto;
import com.luca.projetofinal.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	private final ProdutoService service;
	
	public ProdutoController(ProdutoService service) {
		this.service = service;
	}

	@GetMapping
	public List<Produto> listar() {
		return service.listarAll();
	}
	
	@GetMapping("/{id}")
	public ProdutoDTO buscarId(@PathVariable Long id) {
		Produto produto = service.buscarId(id);
		return service.converterParaDTO(produto);
	}
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		return service.salvar(produto);
	}
	
	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		return service.atualizar(id, produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}
