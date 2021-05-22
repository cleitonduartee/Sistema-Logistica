package com.cleitonduarte.logistica.api.model;

import com.cleitonduarte.logistica.domain.model.Destinatario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioModel {

	private String nome;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	
	public DestinatarioModel(Destinatario destinatario) {
		nome = destinatario.getNome();
		logradouro = destinatario.getLogradouro();
		numero = destinatario.getNumero();
		complemento = destinatario.getComplemento();
		bairro = destinatario.getBairro();
	}
}
