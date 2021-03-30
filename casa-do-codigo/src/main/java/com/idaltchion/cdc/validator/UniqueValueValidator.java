package com.idaltchion.cdc.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

	private String domainAttribute;
	private Class<?> domainClass;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(UniqueValue params) {
		this.domainAttribute = params.field();
		this.domainClass = params.entity();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager
				.createQuery("SELECT 1 FROM " + domainClass.getName() + " WHERE " + domainAttribute + " = :value");
		query.setParameter("value", value);
		List<?> result = query.getResultList();

		Assert.state(result.size() <= 1, String.format("Foi encontrado mais de um %s com o atributo %s = %s",
				domainClass, domainAttribute, value));

		return result.isEmpty();
	}

}
