package com.idaltchion.cdc.categoria;

import javax.validation.constraints.NotBlank;

import com.idaltchion.cdc.validator.UniqueValue;

public class CategoriaRequest {

	@NotBlank
	@UniqueValue(entity = Categoria.class, field = "nome", message = "{categoria.nome.unique}")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}
	
}
