package com.zessh.jumbo.validation.avaliadoid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AvaliadoIdValidator.class)
public @interface ValidAvaliadoId {
    String message() default "O ID do avaliado não existe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

