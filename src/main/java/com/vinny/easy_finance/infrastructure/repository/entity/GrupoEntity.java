package com.vinny.easy_finance.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name = "grupos")
@Entity
public class GrupoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String grupo;

    private String email;

    private String senha;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<UsuarioEntity> usuarios;
}

