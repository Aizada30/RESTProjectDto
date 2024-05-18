package global.security.jwt;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JwtService {
    @Value("${spring.jwt.secret_key}")
    private String secretKey;

    public String generationToken(UserDetails userDetails) {
        return com.auth0.jwt.JWT.create()
                .withClaim("userName", userDetails.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(Date.from(ZonedDateTime.now().plusMinutes(60).toInstant()))
                .sign(Algorithm.HMAC256(secretKey));
    }

    public String validateToken(String token) {
        JWTVerifier jwtVerifier =
                com.auth0.jwt.JWT.require(
                                Algorithm.HMAC256(secretKey))
                        .build();
        DecodedJWT jwt = jwtVerifier.verify(token);
        return jwt.getClaim("username").asString();
    }
}