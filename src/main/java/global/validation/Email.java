package global.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Abdyrazakova Aizada
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValid.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
public @interface Email {

    String message() default "Email mush ended with '@' and '.com";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
