package com.concrete.api.test.config;

import com.concrete.api.test.model.User;
import com.concrete.api.test.repositories.UserRepository;
import com.concrete.api.test.services.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Token extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository repository;

    public Token(TokenService tokenService, UserRepository repository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken (request);
        boolean valido = tokenService.isTokenValido(token);
        if (valido) {
            autenticarCliente(token);
        }


        filterChain.doFilter(request, response);

    }

    private void autenticarCliente(String token) {
        Long idUser = tokenService.getIdUser(token);
        User user = repository.findById(idUser.toString()).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty () || token.startsWith ("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
}
