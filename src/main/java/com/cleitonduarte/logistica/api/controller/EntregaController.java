package com.cleitonduarte.logistica.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cleitonduarte.logistica.api.model.EntregaModel;
import com.cleitonduarte.logistica.domain.model.Entrega;
import com.cleitonduarte.logistica.domain.repository.EntregaRepository;
import com.cleitonduarte.logistica.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping(value = "/entregas")
public class EntregaController {
	
	@Autowired
	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@RequestBody Entrega entrega) {
		return solicitacaoEntregaService.solicitar(entrega);
	}
	
	@GetMapping
	public List<EntregaModel> listar(){
		List<Entrega>listEntrega = entregaRepository.findAll();
		return listEntrega
				.stream().map(entrega -> convertEntregaModel(entrega))
				.collect(Collectors.toList());
		
	}
	@GetMapping(value = "/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId){
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok().body(convertEntregaModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	private EntregaModel convertEntregaModel(Entrega entrega) {
		return new EntregaModel(entrega);
	}

}
