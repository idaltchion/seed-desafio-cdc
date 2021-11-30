package com.idaltchion.cdc.pagamento;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class PagamentoPedido {

	@PositiveOrZero
	@NotNull
	private BigDecimal total;

	@NotNull
	@Valid
	private List<PagamentoPedidoItem> itens;

	public PagamentoPedido(@PositiveOrZero BigDecimal total, @NotNull List<PagamentoPedidoItem> itens) {
		super();
		this.total = total;
		this.itens = itens;
	}
	
	@Override
	public String toString() {
		return "PagamentoPedido [total=" + total + ", itens=" + itens + "]";
	}

}
