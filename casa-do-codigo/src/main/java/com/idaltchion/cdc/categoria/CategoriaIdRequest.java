package com.idaltchion.cdc.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaIdRequest {

	@NotBlank
	private Long id;

	public CategoriaIdRequest(@NotBlank Long id) {
		super();
		this.id = id;
	}

}
