package com.cleitonduarte.logistica.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleitonduarte.logistica.domain.exception.NegocioException;
import com.cleitonduarte.logistica.domain.model.Entrega;
import com.cleitonduarte.logistica.domain.model.StatusEntrega;
import com.cleitonduarte.logistica.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {

	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	public  void finalizar(Long entregaId) {
		
		Entrega entrega = buscaEntregaService.busca(entregaId);
		entrega.finalizar();
		
		
		entregaRepository.save(entrega);
		
	}
}
