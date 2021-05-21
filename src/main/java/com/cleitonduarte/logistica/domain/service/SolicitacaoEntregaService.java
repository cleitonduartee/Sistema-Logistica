package com.cleitonduarte.logistica.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cleitonduarte.logistica.domain.model.Cliente;
import com.cleitonduarte.logistica.domain.model.Entrega;
import com.cleitonduarte.logistica.domain.model.StatusEntrega;
import com.cleitonduarte.logistica.domain.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	@Autowired
	private CatalogoClienteService catalogoClienteService;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());						
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
