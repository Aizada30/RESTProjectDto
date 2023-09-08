package global.dto.request;


import global.validation.Email;
import lombok.Builder;

/**
 * Abdyrazakova Aizada
 */
@Builder
public record SignInRequest(
        @Email
        String email,
        String password

) {
}
