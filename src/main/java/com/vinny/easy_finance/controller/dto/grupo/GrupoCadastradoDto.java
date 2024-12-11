package com.vinny.easy_finance.controller.dto.grupo;

import lombok.Builder;

import java.util.UUID;

@Builder
public record GrupoCadastradoDto(
        UUID id,
        String grupo,
        String email
){}
