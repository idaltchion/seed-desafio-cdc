package com.idaltchion.cdc.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotBlank
	@Min(100)
	private Integer paginas;

	@NotBlank
	@UniqueValue(entity = Livro.class, field = "isbn", message = "{livro.isbn.unico}")
	private String isbn;

	@FutureOrPresent
	private LocalDate dataPublicacao;

	@NotBlank
	private Long idCategoria;

	@NotBlank
	private Long idAutor;

	public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer paginas, @NotBlank String isbn,
			@FutureOrPresent LocalDate dataPublicacao, @NotBlank Long idCategoria, @NotBlank Long idAutor) {
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

}
