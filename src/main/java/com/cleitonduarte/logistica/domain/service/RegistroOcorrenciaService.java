package com.cleitonduarte.logistica.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cleitonduarte.logistica.domain.model.Entrega;
import com.cleitonduarte.logistica.domain.model.Ocorrencia;

@Service
public class RegistroOcorrenciaService {
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;

	@Transactional
	public Ocorrencia registrar(Long entregaID, String descricao) {
		Entrega entrega = buscaEntregaService.busca(entregaID);
		
		return entrega.adicionarOcorrencia(descricao);
	}
}
