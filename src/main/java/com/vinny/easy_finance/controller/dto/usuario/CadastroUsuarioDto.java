package com.vinny.easy_finance.controller.dto.usuario;

import com.vinny.easy_finance.enums.Permissao;
import lombok.Builder;

@Builder
public record CadastroUsuarioDto(
        String nome,
        String email,
        String senha
){}
