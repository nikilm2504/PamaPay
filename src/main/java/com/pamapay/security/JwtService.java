package com.pamapay.security;
import com.pamapay.config.JwtProperties;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import com.pamapay.auth.domain.User;
import io.jsonwebtoken.Jwts;
import java.time.Instant;
import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import java.util.UUID;
@Service
public class JwtService {
    private final JwtProperties jwtProperties;
    public JwtService(JwtProperties jwtProperties){
        this.jwtProperties=jwtProperties;
    }
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(
                jwtProperties.secret()
                        .getBytes(StandardCharsets.UTF_8)
        );
    }
    public String generateAcessToken(User user){
        Instant now=Instant.now();
        Instant expiration=now.plusMillis(jwtProperties.expiration());
        return Jwts.builder()
                .subject(user.getEmail())
                .claim("userId", user.getId().toString())
                .claim("role", user.getRole().name())
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiration))
                .signWith(getSigningKey())
                .compact();
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }
    public UUID extractUserId(String token) {

        String userId = extractAllClaims(token)
                .get("userId", String.class);

        return UUID.fromString(userId);
    }
    public String extractRole(String token) {

        return extractAllClaims(token)
                .get("role", String.class);

    }
    public boolean isTokenExpired(String token) {

        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }
    public boolean isTokenValid(String token) {

        try {

            return !isTokenExpired(token);

        } catch (JwtException | IllegalArgumentException exception) {

            return false;
        }
    }
}

