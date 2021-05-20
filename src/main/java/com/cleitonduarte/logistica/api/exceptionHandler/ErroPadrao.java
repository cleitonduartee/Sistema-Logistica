package com.cleitonduarte.logistica.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErroPadrao {

	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<CamposError>campos;
		
}
