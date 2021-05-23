package com.cleitonduarte.logistica.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cleitonduarte.logistica.api.model.OcorrenciaModel;
import com.cleitonduarte.logistica.domain.model.Ocorrencia;

@Component
public class OcorrenciaAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaModel.class);
	}

}
