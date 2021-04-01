package com.idaltchion.cdc.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.idaltchion.cdc.autor.Autor;
import com.idaltchion.cdc.categoria.Categoria;
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
	private LocalDate dataPublicacao;

	@NotNull
	private Long idCategoria;

	@NotNull
	private Long idAutor;
	
	public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
			@FutureOrPresent LocalDate dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public Livro toModel(EntityManager manager) {
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		Autor autor = manager.find(Autor.class, idAutor);
		Assert.state(Objects.nonNull(categoria), "Categoria não pode ser nula");
		Assert.state(Objects.nonNull(autor), "Autor não pode ser nulo");
		return new Livro(this.titulo, this.resumo, this.sumario,
				this.preco, this.paginas, this.isbn,
				this.dataPublicacao, categoria,
				autor);	
	}

}
