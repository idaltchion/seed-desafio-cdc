package com.idaltchion.cdc.autor;

import javax.validation.constraints.NotBlank;

public class AutorIdRequest {

	@NotBlank
	private Long id;

	public AutorIdRequest(@NotBlank Long id) {
		super();
		this.id = id;
	}

}
