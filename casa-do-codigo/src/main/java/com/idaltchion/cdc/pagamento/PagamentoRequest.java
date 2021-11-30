package com.idaltchion.cdc.pagamento;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.idaltchion.cdc.estado.Estado;
import com.idaltchion.cdc.pais.Pais;
import com.idaltchion.cdc.validator.Documento;
import com.idaltchion.cdc.validator.ExistsId;

public class PagamentoRequest {

	private @NotBlank String nome;

	private @NotBlank String sobrenome;

	private @NotBlank @Email String email;

	@Documento
	private @NotBlank String documento;

	private @NotBlank String cep;

	private @NotBlank String endereco;

	private @NotBlank String complemento;

	private @NotBlank String cidade;

	@ExistsId(entity = Pais.class, field = "id")
	private @NotNull Long idPais;

	@ExistsId(entity = Estado.class, field = "id")
	private Long idEstado;

	private @NotBlank String telefone;

	@Valid
	private @NotNull PagamentoPedido pedido;
	
	public PagamentoRequest(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Email String email,
			@NotBlank String documento, @NotBlank String cep, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone, @NotNull PagamentoPedido pedido) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "PagamentoRequest [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", documento="
				+ documento + ", cep=" + cep + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade="
				+ cidade + ", idPais=" + idPais + ", idEstado=" + idEstado + ", telefone=" + telefone + ", pedido=" + pedido + "]";
	}

	public Long getIdPais() {
		return idPais;
	}
	
	public Long getIdEstado() {
		return idEstado;
	}
	
}
