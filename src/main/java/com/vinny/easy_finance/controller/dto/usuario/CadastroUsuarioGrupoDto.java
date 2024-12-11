package com.vinny.easy_finance.controller.dto.usuario;

import com.vinny.easy_finance.enums.Role;
import lombok.Builder;

@Builder
public record CadastroUsuarioGrupoDto(
        Role role
){}
