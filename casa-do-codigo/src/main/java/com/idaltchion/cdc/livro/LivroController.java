package com.idaltchion.cdc.livro;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

	@PostMapping
	public String criar(@RequestBody @Valid LivroRequest livroRequest) {
		return "...criando livro...";
	}
	
}
