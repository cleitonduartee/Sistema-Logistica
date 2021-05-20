package com.cleitonduarte.logistica.api.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CamposError {

	private String nome;
	private String mensagem;
}
