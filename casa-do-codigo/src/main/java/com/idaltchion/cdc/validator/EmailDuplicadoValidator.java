package com.idaltchion.cdc.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.idaltchion.cdc.autor.Autor;
import com.idaltchion.cdc.autor.AutorRequest;
import com.idaltchion.cdc.repository.AutorRepository;

@Component
public class EmailDuplicadoValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AutorRequest autorRequest = (AutorRequest) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(autorRequest.getEmail());

		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null,
					String.format("Já existe cadastro com o e-mail %s", autorRequest.getEmail()));
		}

	}

}
