package com.luca.projetofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luca.projetofinal.model.Cliente;
import com.luca.projetofinal.repository.ClienteRepository;



@Service
public class ClienteService {
	
	private final ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public List<Cliente> listarAll(){
		return repository.findAll();
	}
	
	public Cliente buscarId(Long id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
	}
	
	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Cliente atualizar(Long id, Cliente clienteAtualizada) {
		Cliente cliente = buscarId(id);
		
		cliente.setNome(clienteAtualizada.getNome());
		cliente.setEmail(clienteAtualizada.getEmail());
		cliente.setPedidos(clienteAtualizada.getPedidos());
		
		return repository.save(cliente);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
