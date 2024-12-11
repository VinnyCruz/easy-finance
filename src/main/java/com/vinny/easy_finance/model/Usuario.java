package com.vinny.easy_finance.model;

import com.vinny.easy_finance.enums.Role;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Usuario {
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private List<Compra> compras;
    private Grupo grupo;
    private Role role;
}

