package com.idaltchion.cdc.validator;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.idaltchion.cdc.estado.Estado;
import com.idaltchion.cdc.pagamento.PagamentoRequest;
import com.idaltchion.cdc.pais.Pais;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

	@Autowired
	private EntityManager manager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return PagamentoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		PagamentoRequest request = (PagamentoRequest) target;
		Pais pais = manager.find(Pais.class, request.getIdPais());
		Estado estado = manager.find(Estado.class, request.getIdEstado());
		if (!estado.pertenceAoPais(pais)) {
			errors.rejectValue("idEstado", null, "Não existe Estado cadastrado para o Pais informado");
		}
	}

}
