package global.api;

import global.dto.request.SignInRequest;
import global.dto.request.SignUpRequest;
import global.dto.response.AuthenticationResponse;
import global.service.AutenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Authentication Api")
public class AuthentificationApi {

    private final AutenticationService autenticationService;

    @PostMapping("/signUp")
    @Operation(summary = "Sing Up", description = "To sign up fill the all columns")
    AuthenticationResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        log.info("test");
        return autenticationService.signUp(signUpRequest);
    }

    @PostMapping("/signIn")
    AuthenticationResponse signIn(@RequestBody SignInRequest singInRequest){
        return autenticationService.signIn(singInRequest);
    }
}