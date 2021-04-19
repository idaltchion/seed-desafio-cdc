package com.idaltchion.cdc.pais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.idaltchion.cdc.validator.UniqueValue;

public class PaisRequest {

	@NotBlank
	@UniqueValue(entity = Pais.class, field = "nome")
	private String nome;

	@JsonCreator(mode = Mode.PROPERTIES)
	public PaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
	
}
