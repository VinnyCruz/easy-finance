package com.vinny.easy_finance.domain;

import com.vinny.easy_finance.enums.Permissao;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PACKAGE)
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Grupo {
    private UUID id;
    private String grupo;
    private Usuario admin;
    private List<Usuario> usuarios;

    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        usuario.setGrupo(this);
    }
}
