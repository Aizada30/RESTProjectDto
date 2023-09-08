package global.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Abdyrazakova Aizada
 */
public class PhoneNumberValidation implements ConstraintValidator<PhoneNumberValid,String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {

        return phoneNumber.startsWith("+996") && phoneNumber.length()==13;
    }
}
