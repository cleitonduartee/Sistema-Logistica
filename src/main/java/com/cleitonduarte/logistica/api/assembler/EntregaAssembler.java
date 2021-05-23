package com.cleitonduarte.logistica.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cleitonduarte.logistica.api.model.EntregaModel;
import com.cleitonduarte.logistica.api.model.input.EntregaInput;
import com.cleitonduarte.logistica.domain.model.Entrega;

@Component
public class EntregaAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public EntregaModel toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaModel.class);
	}
	
	public List<EntregaModel> toCollectionModel ( List<Entrega> listEntrega){
		return listEntrega.stream().map(entrega ->toModel(entrega)).collect(Collectors.toList());
	}
	
	public Entrega  toEntity (EntregaInput entregaInput){
		return modelMapper.map(entregaInput, Entrega.class);
	}
}
