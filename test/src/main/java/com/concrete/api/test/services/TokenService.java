package com.concrete.api.test.services;

import com.concrete.api.test.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

        @Value("${test.jwt.expiration}")
        private String expiration;

        @Value("${test.jwt.secret}")
        private String secret;


    public String generateToken(User userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getName());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600))
                .signWith(SignatureAlgorithm.HS512, "secret").compact();
    }

        public boolean isTokenValido(String token) {
            try {
                Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
                return true;
            } catch (Exception e) {
                return false;
            }

        }

        public Long getIdUser(String token) {
            Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
            return Long.parseLong(claims.getSubject());
        }

    }


