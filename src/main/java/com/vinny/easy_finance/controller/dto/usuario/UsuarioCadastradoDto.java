package com.vinny.easy_finance.controller.dto.usuario;

import com.vinny.easy_finance.enums.Permissao;

public record UsuarioCadastradoDto(
        String nome,
        String email,
        Permissao permissao
){}
