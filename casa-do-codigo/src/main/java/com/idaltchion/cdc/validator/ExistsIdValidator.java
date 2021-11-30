package com.idaltchion.cdc.validator;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object>{

	private Class<?> domainClass;
	private String domainAttribute;
	
	@PersistenceContext
	EntityManager manager;
	
	@Override
	public void initialize(ExistsId params) {
		this.domainClass = params.entity();
		this.domainAttribute = params.field();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (Objects.isNull(value)) {
			return true;
		}
			
		Query query = manager
				.createQuery("SELECT 1 FROM " + domainClass.getName() + " WHERE " + domainAttribute + " = :value");
		query.setParameter("value", value);
		List<?> results = query.getResultList();

		Assert.state(results.size() <= 1, 
				String.format("Não foi encontrado cadastro de %s com o %s = %s", 
						domainClass.getSimpleName(), domainAttribute, value));
		
		return !results.isEmpty();
	}
	
}
