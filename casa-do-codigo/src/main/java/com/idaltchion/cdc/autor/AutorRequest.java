package com.idaltchion.cdc.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "AutorRequest [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "]";
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
