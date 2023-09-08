package global.api;

import global.dto.request.SignInRequest;
import global.dto.request.SignUpRequest;
import global.dto.response.AuthenticationResponse;
import global.service.AutenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Abdyrazakova Aizada
 */
@RestController
@RequestMapping("/api/in")
@RequiredArgsConstructor
public class AuthentificationApi {

    private final AutenticationService autenticationService;

    @PostMapping("/signUp")
    AuthenticationResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return autenticationService.signUp(signUpRequest);
    }


    @PostMapping("/signIn")
    AuthenticationResponse signIn(@RequestBody SignInRequest singInRequest){
        return autenticationService.signIn(singInRequest);
    }
}
