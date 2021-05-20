package com.cleitonduarte.logistica.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleitonduarte.logistica.domain.model.Cliente;
import com.cleitonduarte.logistica.domain.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository ClienteRepository;

	@GetMapping
	public List<Cliente> listar(){
		return ClienteRepository.findAll();
	}
	@GetMapping(value = "/{clienteId}")
	public ResponseEntity<Cliente> obter(@PathVariable Long clienteId){
		return ClienteRepository.findById(clienteId)
				.map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());				
		
	}
}
