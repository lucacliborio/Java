package com.luca.projetofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.projetofinal.model.Categoria;
import com.luca.projetofinal.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}
	
	public List<Categoria> listarAll(){
		return repository.findAll();
	}
	
	public Categoria buscarId(Long id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Categoria não encontrada"));
	}
	
	public Categoria salvar(Categoria categoria) {
		return repository.save(categoria);
	}
	
	public Categoria atualizar(Long id, Categoria categoriaAtualizada) {
		Categoria categoria = buscarId(id);
		
		categoria.setNome(categoriaAtualizada.getNome());
		categoria.setDescricao(categoriaAtualizada.getDescricao());
		categoria.setProdutos(categoriaAtualizada.getProdutos());
		
		return repository.save(categoria);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
