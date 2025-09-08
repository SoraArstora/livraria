package br.com.livraria.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MatchPasswordValidator.class)
@Target( {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MatchPassword {

    String message() default "Senha incorreta";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
