package com.vinny.easy_finance.controller.dto.grupo;

import lombok.Builder;

@Builder
public record CadastroGrupoDto(
        String grupo,
        String email,
        String senha
){}
