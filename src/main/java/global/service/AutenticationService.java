package global.service;

import global.dto.request.SignInRequest;
import global.dto.request.SignUpRequest;
import global.dto.response.AuthenticationResponse;
import lombok.Builder;

/**
 * Abdyrazakova Aizada
 */
public interface AutenticationService {
    AuthenticationResponse signUp(SignUpRequest signUpRequest);
    AuthenticationResponse signIn(SignInRequest signInRequest);
}
