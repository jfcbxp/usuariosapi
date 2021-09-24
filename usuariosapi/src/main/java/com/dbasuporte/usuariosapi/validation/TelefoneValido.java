package com.dbasuporte.usuariosapi.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^(\\+)[0-9]{1,3}[0-9]{4,14}(?:x.+)?$")
public @interface TelefoneValido {
	String message() default "telefone fora do padrao internacional";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}