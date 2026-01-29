package com.xjh;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;

public class JWTTest {

    @Test
    public void testJWT() {
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "1231231231231231231231231231312313asdsadasdasdasdasdadad")
                .addClaims(Map.of("username", "张三"))
                .addClaims(Map.of("role", "admin"))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                .compact();
        System.out.println(jwt);
    }
}
