package com.idaltchion.cdc.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.idaltchion.cdc.autor.Autor;
import com.idaltchion.cdc.autor.AutorIdRequest;
import com.idaltchion.cdc.categoria.Categoria;
import com.idaltchion.cdc.categoria.CategoriaIdRequest;
import com.idaltchion.cdc.validator.UniqueValue;

public class LivroRequest {

	@NotBlank
	@UniqueValue(entity = Livro.class, field = "titulo", message = "{livro.titulo.unico}")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private Integer paginas;

	@NotBlank
	@UniqueValue(entity = Livro.class, field = "isbn", message = "{livro.isbn.unico}")
	private String isbn;

	@FutureOrPresent
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;

	@NotNull
	@Valid
	private CategoriaIdRequest categoria;

	@NotNull
	@Valid
	private AutorIdRequest autor;

	public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
			@NotNull @Valid CategoriaIdRequest categoria, @NotNull @Valid AutorIdRequest autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toModel(EntityManager manager) {
		System.out.println("categoria: " + categoria.getId() + " - autor: " + this.autor.getId());
		Categoria categoria = manager.find(Categoria.class, this.categoria.getId());
		Autor autor = manager.find(Autor.class, this.autor.getId());
		Assert.state(Objects.nonNull(categoria), "Categoria não pode ser nula");
		Assert.state(Objects.nonNull(autor), "Autor não pode ser nulo");
		return new Livro.Builder()
				.titulo(this.titulo)
				.resumo(this.resumo)
				.sumario(this.sumario)
				.preco(this.preco)
				.paginas(this.paginas)
				.isbn(this.isbn)
				.dataPublicacao(this.dataPublicacao)
				.categoria(categoria)
				.autor(autor)
				.build();
	}

}
