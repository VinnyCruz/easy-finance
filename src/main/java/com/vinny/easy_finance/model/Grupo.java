package com.vinny.easy_finance.model;

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
    private String email;
    private String senha;
    private List<Usuario> usuarios;
}
