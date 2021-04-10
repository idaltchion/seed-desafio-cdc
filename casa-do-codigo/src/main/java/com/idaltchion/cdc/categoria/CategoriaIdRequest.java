package com.idaltchion.cdc.categoria;

import javax.validation.constraints.NotNull;

public class CategoriaIdRequest {

	@NotNull
	private Long id;

	public CategoriaIdRequest(@NotNull Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
