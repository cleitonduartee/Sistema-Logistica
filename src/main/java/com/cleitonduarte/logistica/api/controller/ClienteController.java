package com.cleitonduarte.logistica.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
