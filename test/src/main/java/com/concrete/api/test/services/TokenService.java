package com.concrete.api.test.services;

import com.concrete.api.test.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.util.Date;

@Service
public class TokenService {

        @Value("${test.jwt.expiration}")
        private String expiration;

        @Value("${test.jwt.secret}")
        private String secret;

        public String gerarToken(Authentication authentication) {
            User logado = (User) authentication.getPrincipal();
            Date hoje = new Date ();
            Date dataExpiracao = new Date (hoje.getTime() + Long.parseLong(expiration));

            return Jwts.builder()
                    .setIssuer("API registrando usuários")
                    .setSubject(logado.getId().toString())
                    .setIssuedAt(hoje)
                    .setExpiration (dataExpiracao)
                    .signWith (SignatureAlgorithm.HS256, secret)
                    .compact();

        }

        public boolean isTokenValido(String token) {
            try {
                //Método que devolve o JwsClains (que é um objeto onde consigo recuperar o token e as informações setadas dentro do token
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


