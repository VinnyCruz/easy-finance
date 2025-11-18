package com.vinny.easy_finance.domain;

import com.vinny.easy_finance.enums.Permissao;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private List<Compra> compras;
    private Grupo grupo;
    private Permissao permissao;
}

