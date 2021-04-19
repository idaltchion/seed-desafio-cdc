package com.idaltchion.cdc.pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotNull String nome;

	@Deprecated
	public Pais() {
	}
	
	public Pais(@NotNull String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + "]";
	}
	
}
