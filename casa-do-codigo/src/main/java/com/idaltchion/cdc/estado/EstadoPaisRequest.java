package com.idaltchion.cdc.estado;

import javax.validation.constraints.NotNull;

import com.idaltchion.cdc.pais.Pais;

public class EstadoPaisRequest {

	@NotNull
	private Long id;
	
	public EstadoPaisRequest(Pais pais) {
		id = pais.getId();
	}
	
	public Long getId() {
		return id;
	}
	
}
