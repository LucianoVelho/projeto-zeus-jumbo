package com.zessh.jumpo.validation.usuarioid;

import com.zessh.jumpo.repositories.UsuarioRepositoty;
import com.zessh.jumpo.validation.avaliadoid.ValidAvaliadoId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioIdValidator implements ConstraintValidator<ValidAvaliadoId, Long> {

    @Autowired
    private UsuarioRepositoty usuarioRepositoty;
    @Override
    public void initialize(ValidAvaliadoId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return usuarioRepositoty.existsById(id);
    }
}
