package com.idaltchion.cdc.estado;

import java.net.URI;
import java.util.Objects;

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
@RequestMapping("/estados")
public class EstadoController {

	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> adicionar(@RequestBody @Valid EstadoRequest estadoRequest) {
		Estado novoEstado = estadoRequest.toModel(manager);
		if (Objects.isNull(novoEstado.getPais())) {
			return ResponseEntity.notFound().build();
		}
		manager.persist(novoEstado);
		return ResponseEntity.created(URI.create("/estados/" + novoEstado.getId())).body(novoEstado);
	}
	
}
