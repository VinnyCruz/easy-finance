package com.vinny.easy_finance.controller.dto.usuario;

import com.vinny.easy_finance.enums.Permissao;
import lombok.Builder;

@Builder
public record CadastroUsuarioGrupoDto(
        Permissao permissao
){}
