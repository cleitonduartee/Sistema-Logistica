package com.cleitonduarte.logistica.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.cleitonduarte.logistica.domain.model.Entrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {

	private Long id;
	private String nomeCliente;
	private DestinatarioModel destinatario;
	private BigDecimal taxa;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizada;
	
	public EntregaModel(Entrega entrega) {
		id = entrega.getId();
		nomeCliente = entrega.getCliente().getNome();
		destinatario = new DestinatarioModel(entrega.getDestinatario());
		taxa = entrega.getTaxa();
		dataPedido = entrega.getDataPedido();
		dataFinalizada = entrega.getDataFinalizacao();
	}
	
}
