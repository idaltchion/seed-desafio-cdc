package com.idaltchion.cdc.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.idaltchion.cdc.pais.Pais;
import com.idaltchion.cdc.validator.ExistsId;
import com.idaltchion.cdc.validator.UniqueValue;

public class EstadoRequest {

	@NotBlank
	@UniqueValue(entity = Estado.class, field = "nome", message = "{estado.nome.unico}")
	private String nome;
	
	@NotNull
	@ExistsId(entity = Pais.class, field = "id")
	private Long idPais;
	
	public EstadoRequest(@NotNull String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}
	
	public Long getIdPais() {
		return idPais;
	}
	
	public Estado toModel(EntityManager manager) {
		Pais paisExistente = manager.find(Pais.class, this.idPais);
		Estado estado = new Estado(nome, paisExistente);
		return estado;
	}

}
