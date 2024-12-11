package com.vinny.easy_finance.controller;

import com.vinny.easy_finance.controller.dto.usuario.CadastroUsuarioDto;
import com.vinny.easy_finance.controller.dto.usuario.UsuarioCadastradoDto;
import com.vinny.easy_finance.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/grupos/{idGrupo}/usuarios")
    public ResponseEntity<UsuarioCadastradoDto> criarUsuario(@PathVariable UUID idGrupo, @RequestBody CadastroUsuarioDto cadastroUsuarioDto) {
        UsuarioCadastradoDto usuarioCadastrado = null;
        return ResponseEntity.status(201).body(usuarioCadastrado);
    }
}
