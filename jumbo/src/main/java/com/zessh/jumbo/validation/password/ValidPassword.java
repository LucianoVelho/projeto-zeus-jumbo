package com.zessh.jumbo.validation.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {
    String message() default "Senha inválida. Deve conter pelo menos uma letra maiúscula, uma letra minúscula e um caractere especial.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
