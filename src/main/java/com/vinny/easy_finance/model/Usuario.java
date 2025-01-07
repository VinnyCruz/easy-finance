package com.vinny.easy_finance.model;

import com.vinny.easy_finance.enums.Permissao;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
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

    public Usuario(Grupo grupo, String nome, String email, String senha, Permissao permissao) {
        this.grupo = grupo;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.permissao = permissao;
    }
}

