package com.vinny.easy_finance.controller;

import com.vinny.easy_finance.controller.dto.usuario.LoginUsuarioDto;
import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioDto;
import com.vinny.easy_finance.controller.dto.usuario.UsuarioCadastradoDto;
import com.vinny.easy_finance.controller.dto.usuario.UsuarioLogadoDto;

import com.vinny.easy_finance.infra.security.TokenService;
import com.vinny.easy_finance.repository.entity.UsuarioEntity;
import com.vinny.easy_finance.service.UsuarioService;
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
    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/usuarios/login")
    public ResponseEntity<UsuarioLogadoDto> login(@RequestBody LoginUsuarioDto login){
        var usuarioSenha = new UsernamePasswordAuthenticationToken(login.email(), login.senha());
        var auth = authenticationManager.authenticate(usuarioSenha);
        var token = tokenService.gerarToken((UsuarioEntity) auth.getPrincipal());
        return ResponseEntity.status(200).body(new UsuarioLogadoDto(token));
    }

    @PostMapping("/grupos/{idGrupo}/usuarios")
    public ResponseEntity<UsuarioCadastradoDto> criarUsuario(@PathVariable UUID idGrupo, @RequestBody CadastroUsuarioDto cadastroUsuarioDto) {
        UsuarioCadastradoDto usuarioCadastrado = usuarioService.cadastrarUsuario(idGrupo, cadastroUsuarioDto);
        return ResponseEntity.status(201).body(usuarioCadastrado);
    }
}
