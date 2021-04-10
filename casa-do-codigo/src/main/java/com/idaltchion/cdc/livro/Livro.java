package com.idaltchion.cdc.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import com.idaltchion.cdc.autor.Autor;
import com.idaltchion.cdc.categoria.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer paginas;
	private String isbn;
	private LocalDate dataPublicacao;

	@ManyToOne
	@Valid
	private Categoria categoria;

	@ManyToOne
	@Valid
	private Autor autor;

	private Livro(Builder builder) {
		this.titulo = builder.titulo;
		this.resumo = builder.resumo;
		this.sumario = builder.sumario;
		this.preco = builder.preco;
		this.paginas = builder.paginas;
		this.isbn = builder.isbn;
		this.dataPublicacao = builder.dataPublicacao;
		this.categoria = builder.categoria;
		this.autor = builder.autor;
	}

	public Long getId() {
		return id;
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

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public static class Builder {
		private String titulo;
		private String resumo;
		private String sumario;
		private BigDecimal preco;
		private Integer paginas;
		private String isbn;
		private LocalDate dataPublicacao;
		private Categoria categoria;
		private Autor autor;

		public Builder titulo(final String titulo) {
			this.titulo = titulo;
			return this;
		}

		public Builder resumo(final String resumo) {
			this.resumo = resumo;
			return this;
		}

		public Builder sumario(final String sumario) {
			this.sumario = sumario;
			return this;
		}

		public Builder preco(final BigDecimal preco) {
			this.preco = preco;
			return this;
		}

		public Builder paginas(final Integer paginas) {
			this.paginas = paginas;
			return this;
		}

		public Builder isbn(final String isbn) {
			this.isbn = isbn;
			return this;
		}

		public Builder dataPublicacao(final LocalDate dataPublicacao) {
			this.dataPublicacao = dataPublicacao;
			return this;
		}

		public Builder categoria(final Categoria categoria) {
			this.categoria = categoria;
			return this;
		}

		public Builder autor(final Autor autor) {
			this.autor = autor;
			return this;
		}

		public Livro build() {
			return new Livro(this);
		}

	}

}
