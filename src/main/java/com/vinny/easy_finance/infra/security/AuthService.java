package com.vinny.easy_finance.infra.security;

import com.vinny.easy_finance.infrastructure.repository.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public String login(String email, String senha) {
        var usuarioSenha = new UsernamePasswordAuthenticationToken(email, senha);
        var auth = authenticationManager.authenticate(usuarioSenha);
        return tokenService.gerarToken((UsuarioEntity) auth.getPrincipal());
    }
}

