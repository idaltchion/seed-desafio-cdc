package com.idaltchion.cdc.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Target({ FIELD })
@ConstraintComposition(CompositionType.OR)
@Constraint(validatedBy = { })
@ReportAsSingleViolation
@Retention(RUNTIME)
@Documented
@CPF
@CNPJ
public @interface Documento {

	String message() default "Documento informado deve ser um CPF ou CNPJ válido";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
	
}
