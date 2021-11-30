package com.idaltchion.cdc.pagamento;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idaltchion.cdc.validator.EstadoPertenceAPaisValidator;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoPertenceAPaisValidator);
	}
	
	@PutMapping
	public String efetuar(@RequestBody @Valid PagamentoRequest pagamentoRequest) {
		return pagamentoRequest.toString();
	}
	
}
