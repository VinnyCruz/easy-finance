package com.vinny.easy_finance.controller;

import com.vinny.easy_finance.application.usuario.CadastrarUsuarioUseCase;
import com.vinny.easy_finance.controller.dto.usuario.LoginUsuarioDto;
import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioDto;
import com.vinny.easy_finance.controller.dto.usuario.UsuarioCadastradoDto;
import com.vinny.easy_finance.controller.dto.usuario.UsuarioLogadoDto;
import com.vinny.easy_finance.infra.security.AuthService;
import com.vinny.easy_finance.infra.security.TokenService;
import com.vinny.easy_finance.infrastructure.repository.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UsuarioController {
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final AuthService authService;

    @PostMapping("/usuarios/login")
    public ResponseEntity<UsuarioLogadoDto> login(@RequestBody LoginUsuarioDto login){
        String token = authService.login(login.email(), login.senha());
        return ResponseEntity.ok(new UsuarioLogadoDto(token));
    }

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioCadastradoDto> criarUsuario(@RequestBody CadastroUsuarioDto cadastroUsuarioDto) {
        UsuarioCadastradoDto usuarioCadastrado = cadastrarUsuarioUseCase.executar(cadastroUsuarioDto);
        return ResponseEntity.status(201).body(usuarioCadastrado);
    }
}
