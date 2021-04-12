package com.idaltchion.cdc.livro;

import com.idaltchion.cdc.autor.Autor;

public class LivroDetalheSiteAutorResponse {

	private String nome;
	private String descricao;
	
	LivroDetalheSiteAutorResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}
	
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
