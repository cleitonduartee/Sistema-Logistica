package com.cleitonduarte.logistica.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleitonduarte.logistica.domain.model.Cliente;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@GetMapping
	public List<Cliente> listar(){
		Cliente cli1 = new Cliente(1L, "João3", "joaodascovis@gmail.com", "67 9999999");
		Cliente cli2 = new Cliente(1L, "Maria", "Maria@gmail.com", "67 98888888");
		return Arrays.asList(cli1,cli2);
	}
}
