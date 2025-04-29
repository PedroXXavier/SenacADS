package com.senac.pizzademo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenService {
    private static final String SECRET = "segredo123";
    private static final long EXPIRACAO = 86400000;

    public static String gerarToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRACAO))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static String validarToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getSubject();
    }
}
