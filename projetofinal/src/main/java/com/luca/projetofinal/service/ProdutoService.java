package com.luca.projetofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.projetofinal.model.Categoria;
import com.luca.projetofinal.model.Produto;
import com.luca.projetofinal.repository.CategoriaRepository;
import com.luca.projetofinal.repository.ProdutoRepository;

@Service
public class ProdutoService {

		private final ProdutoRepository repository;
		private final CategoriaRepository categoriaRepository;
		
		public ProdutoService(ProdutoRepository repository, CategoriaRepository categoriaRepository) {
		    this.repository = repository;
		    this.categoriaRepository = categoriaRepository;
		}
		
		public List<Produto> listarAll(){
			return repository.findAll();
		}
		
		public Produto buscarId(Long id) {
			return repository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
		}
		
		public Produto salvar(Produto produto) {

		    if (produto.getCategoria() != null) {
		        Long categoriaId = produto.getCategoria().getId();

		        Categoria categoria = categoriaRepository.findById(categoriaId)
		                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

		        produto.setCategoria(categoria);
		    }

		    return repository.save(produto);
		}
		
		public Produto atualizar(Long id, Produto produtoAtualizado) {

		    Produto produto = buscarId(id);

		    produto.setNome(produtoAtualizado.getNome());
		    produto.setPreco(produtoAtualizado.getPreco());

		    if (produtoAtualizado.getCategoria() != null) {
		        Long categoriaId = produtoAtualizado.getCategoria().getId();

		        Categoria categoria = categoriaRepository.findById(categoriaId)
		                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

		        produto.setCategoria(categoria);
		    }

		    return repository.save(produto);
		}
		
		public void deletar(Long id) {
			repository.deleteById(id);
		}
}
