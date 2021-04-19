package com.idaltchion.cdc.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.idaltchion.cdc.pais.Pais;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@ManyToOne
	private Pais pais;

	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

}
