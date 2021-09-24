package com.dbasuporte.usuariosapi.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { DocumentoValidador.class })
public @interface DocumentoValido {
	String message() default "Documento nao pode ser superior a 2MB e deve ser no formato PDF";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}