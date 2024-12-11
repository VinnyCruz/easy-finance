package com.vinny.easy_finance.controller;

import com.vinny.easy_finance.controller.dto.grupo.CadastroGrupoDto;
import com.vinny.easy_finance.controller.dto.grupo.GrupoCadastradoDto;
import com.vinny.easy_finance.service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class GrupoController {
    private final GrupoService grupoService;

    @PostMapping("/grupos")
    public ResponseEntity<GrupoCadastradoDto> criarGrupo(@RequestBody CadastroGrupoDto cadastroGrupoDto) {
        GrupoCadastradoDto grupoCadastrado = grupoService.cadastrarNovoGrupo(cadastroGrupoDto);
        return ResponseEntity.status(201).body(grupoCadastrado);
    }
}
