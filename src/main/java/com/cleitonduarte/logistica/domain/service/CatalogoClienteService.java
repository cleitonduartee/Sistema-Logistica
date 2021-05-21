package com.cleitonduarte.logistica.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cleitonduarte.logistica.domain.exception.NegocioException;
import com.cleitonduarte.logistica.domain.model.Cliente;
import com.cleitonduarte.logistica.domain.repository.ClienteRepository;

@Service
public class CatalogoClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long cliente_id) {
		return clienteRepository.findById(cliente_id)
				.orElseThrow(()-> new NegocioException("Cliente não encontrado"));

	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
								.stream()
								.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
		}
			
		return clienteRepository.save(cliente);
	}
	@Transactional
	public void excluir(Long clienteId) {
		 clienteRepository.deleteById(clienteId);
	}
	
}
