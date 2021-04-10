package com.idaltchion.cdc.autor;

import javax.validation.constraints.NotNull;

public class AutorIdRequest {

	@NotNull
	private Long id;

	public AutorIdRequest(@NotNull Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
