package com.zessh.jumbo.validation.avaliadoid;

import com.zessh.jumbo.repositories.AvaliadoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AvaliadoIdValidator implements ConstraintValidator<ValidAvaliadoId, Long> {

    @Autowired
    private AvaliadoRepository avaliadoRepository;
    @Override
    public void initialize(ValidAvaliadoId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return avaliadoRepository.existsById(id);
    }
}
