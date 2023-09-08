package global.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Abdyrazakova Aizada
 */
@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {

    private Long id;
    private String email;
    private String token;


}
