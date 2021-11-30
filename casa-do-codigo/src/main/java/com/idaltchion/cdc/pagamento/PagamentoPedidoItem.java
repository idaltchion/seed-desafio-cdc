package com.idaltchion.cdc.pagamento;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.idaltchion.cdc.livro.Livro;
import com.idaltchion.cdc.validator.ExistsId;

public class PagamentoPedidoItem {

	@NotNull
	@ExistsId(entity = Livro.class, field = "id")
	private Long idLivro;
	
	@NotNull
	@Positive
	private Integer quantidade;
	
	public PagamentoPedidoItem(@NotNull Long idLivro, @NotNull @Positive Integer quantidade) {
		super();
		this.idLivro = idLivro;
		this.quantidade = quantidade;
	}

	public Long getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	@Override
	public String toString() {
		return "PagamentoPedidoItem [idLivro=" + idLivro + ", quantidade=" + quantidade + "]";
	}
	
}
