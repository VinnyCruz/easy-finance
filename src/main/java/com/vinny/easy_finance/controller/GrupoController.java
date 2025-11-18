package com.vinny.easy_finance.controller;

import com.vinny.easy_finance.application.grupo.CadastrarGrupoUseCase;
import com.vinny.easy_finance.controller.dto.grupo.CadastroGrupoDto;
import com.vinny.easy_finance.controller.dto.grupo.GrupoCadastradoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class GrupoController {
    private final CadastrarGrupoUseCase cadastrarGrupoUseCase;

    @PostMapping("/grupos")
    public ResponseEntity<GrupoCadastradoDto> criarGrupo(@PathVariable UUID idUsuario, @RequestBody CadastroGrupoDto cadastroGrupoDto) {
            GrupoCadastradoDto grupoCadastrado = cadastrarGrupoUseCase.executar(idUsuario, cadastroGrupoDto);
        return ResponseEntity.status(201).body(grupoCadastrado);
    }
}
