package global.dto.request;

import global.entity.Role;
import global.validation.Email;
import lombok.Builder;

@Builder
public record SignUpRequest(
        @Email
        String email,
        String password,
        Role role
) {
}