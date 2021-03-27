package com.idaltchion.cdc.autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idaltchion.cdc.validator.EmailDuplicadoValidator;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private EmailDuplicadoValidator emailDuplicadoValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(emailDuplicadoValidator);
	}

	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid AutorRequest autorRequest) {
		Autor autor = autorRequest.toModel();
		manager.persist(autor);
		return autor.toString();
	}

}
