package com.idaltchion.cdc.pais;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> adicionar(@RequestBody @Valid PaisRequest paisRequest) {
		Pais novoPais = paisRequest.toModel();
		manager.persist(novoPais);
		return ResponseEntity.created(URI.create("/paises/" + novoPais.getId())).body(novoPais);
	}
	
}
