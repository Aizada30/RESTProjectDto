package global.service.impl;

import global.dto.request.SignInRequest;
import global.dto.request.SignUpRequest;
import global.dto.response.AuthenticationResponse;
import global.entity.User;
import global.repo.UserRepo;
import global.security.jwt.JwtService;
import global.service.AutenticationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticationServiceImpl implements AutenticationService {

    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        if (userRepo.existsByEmail(signUpRequest.email())) {
            throw new BadCredentialsException(String.format(
                    "User with email: %s already exists!", signUpRequest.email()));
        }
        User user = User.builder()
                .email(signUpRequest.email())
                .password(passwordEncoder.encode(signUpRequest.password()))
                .role(signUpRequest.role())
                .build();
        userRepo.save(user);
        String jwtToken = jwtService.generationToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        User user = userRepo.getUserByEmail(signInRequest.email())
                .orElseThrow(() -> new EntityNotFoundException(
                        "USer with email: " + signInRequest.email() + " not found"
                ));

        if(signInRequest.email().isBlank()){
            throw new BadCredentialsException("Email doesn't exist!");
        }

        if(!passwordEncoder.matches(signInRequest.password(), user.getPassword())){
            throw new BadCredentialsException("Incorrect password!");
        }

        String jwtToken=jwtService.generationToken(user);

        return AuthenticationResponse
                .builder()
                .email(user.getEmail())
                .token(jwtToken)
                .build();
    }
}