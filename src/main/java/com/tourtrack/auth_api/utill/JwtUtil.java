package com.tourtrack.auth_api.utill;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "SOME_SUPER_SECRET_KEY_CHANGE_THIS";

    public String generateToken(String email) {
        long expirationMs = 1000 * 60 * 60; // 1 hour

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, SECRET.getBytes())
                .compact();
    }
}
