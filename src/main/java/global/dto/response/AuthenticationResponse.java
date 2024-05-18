package global.dto.response;

import global.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {
    private Long id;
    private String email;
    private String token;
    private Role role;
}