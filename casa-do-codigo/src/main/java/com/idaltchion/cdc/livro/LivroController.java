package com.idaltchion.cdc.livro;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> criar(@RequestBody @Valid LivroRequest livroRequest) {
		Livro novoLivro = livroRequest.toModel(manager);
		manager.persist(novoLivro);
		return ResponseEntity.created(URI.create("/livros/" + novoLivro.getId())).body(novoLivro);
	}
	
	@GetMapping
	public List<LivroResponse> listar() {
		return manager.createQuery("from Livro", Livro.class)
				.getResultList()
				.stream()
				.map(livro -> new LivroResponse(livro))
				.collect(Collectors.toList());
	}
	
}
