package com.luca.projetofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.projetofinal.model.Produto;
import com.luca.projetofinal.repository.ProdutoRepository;

@Service
public class ProdutoService {

		private final ProdutoRepository repository;
		
		public ProdutoService(ProdutoRepository repository) {
			this.repository = repository;
		}
		
		public List<Produto> listarAll(){
			return repository.findAll();
		}
		
		public Produto buscarId(Long id) {
			return repository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
		}
		
		public Produto salvar(Produto produto) {
			return repository.save(produto);
		}
		
		public Produto atualizar(Long id, Produto produtoAtualizado) {
			Produto produto = buscarId(id);
			
			produto.setNome(produtoAtualizado.getNome());
			produto.setPreco(produtoAtualizado.getPreco());
			
			return repository.save(produto);
		}
		
		public void deletar(Long id) {
			repository.deleteById(id);
		}
}
