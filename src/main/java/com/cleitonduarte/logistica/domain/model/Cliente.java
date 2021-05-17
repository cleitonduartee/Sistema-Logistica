package com.cleitonduarte.logistica.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Cliente {

	private Long id;
	private String nome;
	private String email;
	private String telefone;	
	
}
