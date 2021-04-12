package com.idaltchion.cdc.livro;

import java.math.BigDecimal;

public class LivroDetalheSiteResponse {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer paginas;
	private String isbn;
	private LivroDetalheSiteAutorResponse autor;

	public LivroDetalheSiteResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.autor = new LivroDetalheSiteAutorResponse(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LivroDetalheSiteAutorResponse getAutor() {
		return autor;
	}

}
