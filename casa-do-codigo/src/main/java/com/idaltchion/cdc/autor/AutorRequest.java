package com.idaltchion.cdc.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.idaltchion.cdc.validator.UniqueValue;

public class AutorRequest {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	@UniqueValue(entity = Autor.class, field = "email", message = "{autor.email.unique}")
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AutorRequest [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "]";
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
