package br.com.zupacademy.ratkovski.casadocodigo.config.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ExisteUmEstadoPorPaisValidator.class})
@Target(TYPE)
@Retention(RUNTIME)
public @interface ExisteUmEstadoPorPais {
	String message() default "{Já existe um estado com este nome registrado neste País}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };

}
	


