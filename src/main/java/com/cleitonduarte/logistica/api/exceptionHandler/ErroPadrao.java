package com.cleitonduarte.logistica.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Data
@NoArgsConstructor
public class ErroPadrao {

	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<CamposError>campos;
		
}
