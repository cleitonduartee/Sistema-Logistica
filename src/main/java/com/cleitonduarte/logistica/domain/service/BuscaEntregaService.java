package com.cleitonduarte.logistica.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleitonduarte.logistica.domain.exception.EntidadeNaoEncontradaException;
import com.cleitonduarte.logistica.domain.exception.NegocioException;
import com.cleitonduarte.logistica.domain.model.Entrega;
import com.cleitonduarte.logistica.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega busca(Long entregaId) {
	return entregaRepository.findById(entregaId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
