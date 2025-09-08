package br.com.livraria.validation;

import br.com.livraria.utils.UserUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MatchPasswordValidator implements ConstraintValidator<MatchPassword, String> {

    private final UserUtils userUtils;

    @Override
    public void initialize(MatchPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String oldPassword, ConstraintValidatorContext constraintValidatorContext) {
        return userUtils.getAuthorizedUser().getPassword().equals(oldPassword);
    }
}
