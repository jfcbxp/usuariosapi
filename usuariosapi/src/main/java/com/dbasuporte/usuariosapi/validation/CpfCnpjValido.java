package com.dbasuporte.usuariosapi.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@ConstraintComposition(CompositionType.OR)
@CPF
@CNPJ
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface CpfCnpjValido {

	String message() default "o campo deve ser formatado como cpf ou cnpj";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Documented
	@Target({ ElementType.FIELD })
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		CpfCnpjValido[] value();
	}
}